package com.imc.assignment;

import com.imc.assignment.domain.Player;
import com.imc.assignment.domain.Score;
import com.imc.assignment.service.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication implements CommandLineRunner {

    private Game game;

    private Logger log = LoggerFactory.getLogger(GameApplication.class);

    public GameApplication(Game game) {
        this.game = game;
    }

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }

    @Override
    public void run(String... args) {
        game.init();
        game.play();
        displayScore(game.getScore());
    }

    private void displayScore(Score score){
        log.info("Final Score is:");
        score.getScore().forEach((k,v) -> log.info("{}:{}", ((Player) k).getPlayerName(), v));

    }
}
