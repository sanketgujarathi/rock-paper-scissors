package com.imc.assignment.domain;

import java.util.Random;

public class CpuPlayerImpl implements Player {

    @Override
    public PlayerMove getNextMove() {
        return PlayerMove.values()[new Random().nextInt(PlayerMove.values().length)];
    }

    @Override
    public String getPlayerName() {
        return "CPU";
    }

    @Override
    public void init() {
        //Not action required
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
