package com.imc.assignment.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.imc.assignment.domain.PlayerMove.valueOf;

@Component
@Qualifier("user")
public class CommandLinePlayerImpl implements Player {

    private String playerName;

    private Logger log = LoggerFactory.getLogger(CommandLinePlayerImpl.class);

    @Override
    public PlayerMove getNextMove() {

        while(true) {
            log.info("Player {} enter your move:", playerName);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            try {
                return valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                log.info("Invalid move! Try again.");
            }
        }
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    public void init() {
        log.info("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        this.playerName = name.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        return equalsDefault(o);
    }

    @Override
    public int hashCode() {
        return hashCodeDefault();
    }
}
