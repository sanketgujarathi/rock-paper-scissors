package com.imc.assignment.domain;

public enum PlayerMove {

    ROCK {
        @Override
        public boolean beats(PlayerMove move) {
            return this == SCISSORS;
        }
    }, PAPER {
        @Override
        public boolean beats(PlayerMove move) {
            return this == ROCK;
        }
    }, SCISSORS {
        @Override
        public boolean beats(PlayerMove move) {
            return this == PAPER;
        }
    };

    public abstract boolean beats(PlayerMove move);
}
