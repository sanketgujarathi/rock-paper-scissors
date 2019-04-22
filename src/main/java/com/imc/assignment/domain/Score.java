package com.imc.assignment.domain;

import java.util.Map;

public interface Score<T> {

    void init(Player player);

    void increaseScore(Player player);

    Map<Player, T> getScore();
}
