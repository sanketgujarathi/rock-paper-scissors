package com.imc.assignment.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier("cpu")
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
