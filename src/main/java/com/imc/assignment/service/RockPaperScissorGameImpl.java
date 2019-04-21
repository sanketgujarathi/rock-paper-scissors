package com.imc.assignment.service;

import com.imc.assignment.domain.Player;
import com.imc.assignment.domain.PlayerMove;
import com.imc.assignment.domain.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class RockPaperScissorGameImpl implements Game {

    private Player player1;

    private Player player2;

    private Score score;

    private int turns;

    private static Logger log = LoggerFactory.getLogger(RockPaperScissorGameImpl.class);

    public RockPaperScissorGameImpl(@Qualifier("user") Player player1, @Qualifier("cpu") Player player2, Score score) {
        this.player1 = player1;
        this.player2 = player2;
        this.score = score;
    }

    @Override
    public void init() {
        log.info("Welcome to the game of Rock-Paper-Scissors!");
        log.info("Enter number of turns you wish to play:");
        Scanner sc = new Scanner(System.in);
        this.turns = sc.nextInt();
        player1.init();
        player2.init();
        this.score.init(player1,player2);
    }

    @Override
    public void play() {

        for (int i = 0; i < turns; i++) {

            PlayerMove player1Move = player1.getNextMove();
            PlayerMove player2Move = player2.getNextMove();
            log.info("{}'s move: {}", player1.getPlayerName(), player1Move);
            log.info("{}'s move: {}", player2.getPlayerName(), player2Move);
            if (player1Move == player2Move) {
                log.info("It's a tie!");
            } else {
                Player winner = player1Move.beats(player2Move) ? player1 : player2;
                score.increaseScore(winner);
                log.info("Player {} wins the round", winner.getPlayerName());
            }
        }
    }

    @Override
    public Score getScore() {
        return score;
    }
}
