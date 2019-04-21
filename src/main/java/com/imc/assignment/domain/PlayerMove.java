package com.imc.assignment.domain;

public enum PlayerMove {

    ROCK {
        @Override
        public boolean beats(PlayerMove move) {
            return move == SCISSORS;
        }
    }, PAPER {
        @Override
        public boolean beats(PlayerMove move) {
            return move == ROCK;
        }
    }, SCISSORS {
        @Override
        public boolean beats(PlayerMove move) {
            return move == PAPER;
        }
    };

    public abstract boolean beats(PlayerMove move);
}
