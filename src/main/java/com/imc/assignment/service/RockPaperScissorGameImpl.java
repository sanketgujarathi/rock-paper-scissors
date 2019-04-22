package com.imc.assignment.service;

import com.imc.assignment.domain.Player;
import com.imc.assignment.domain.PlayerMove;
import com.imc.assignment.domain.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

@Service
public class RockPaperScissorGameImpl implements Game {

    private static Logger log = LoggerFactory.getLogger(RockPaperScissorGameImpl.class);
    private List<Player> players;
    private Score score;
    private int turns;

    public RockPaperScissorGameImpl(Score score) {
        this.score = score;
        players = new ArrayList<>();
    }


    @Override
    public void init(Player... players) {
        if (players != null && players.length == 2) {
            log.info("Welcome to the game of Rock-Paper-Scissors!");
            log.info("Enter number of turns you wish to play:");
            Scanner sc = new Scanner(System.in);
            this.turns = sc.nextInt();
            Stream.of(players).forEach(this::initPlayer);
        } else {
            log.error("Invalid number of players! This is a 2 player game");
            throw new IllegalArgumentException("Initialize the game with 2 player only");
        }
    }


    private void initPlayer(Player player) {
        players.add(player);
        player.init();
        this.score.init(player);
    }

    @Override
    public void play() {

        for (int i = 0; i < turns; i++) {
            log.info("Round {}/{}", i + 1, turns);
            Player player1 = players.get(0);
            Player player2 = players.get(1);
            Optional<Player> winner = determineWinner(player1, player2);
            if (winner.isPresent()) {
                score.increaseScore(winner.get());
                log.info("Player {} wins the round", winner.get().getPlayerName());
            }
        }
    }


    private Optional<Player> determineWinner(Player player1, Player player2) {

        PlayerMove player1Move = player1.getNextMove();
        PlayerMove player2Move = player2.getNextMove();
        log.info("{}'s move: {}", player1.getPlayerName(), player1Move);
        log.info("{}'s move: {}", player2.getPlayerName(), player2Move);
        if (player1Move == player2Move) {
            log.info("It's a tie!");
            return Optional.empty();
        } else {
            return player1Move.beats(player2Move) ? Optional.of(player1) : Optional.of(player2);
        }
    }


    @Override
    public Score getScore() {
        return score;
    }
}
