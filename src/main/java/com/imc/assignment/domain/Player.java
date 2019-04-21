package com.imc.assignment.domain;

public interface Player {

    PlayerMove getNextMove();

    String getPlayerName();

    void init();
}
