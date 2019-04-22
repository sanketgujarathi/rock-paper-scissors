package com.imc.assignment.domain;

import java.util.Map;

public interface Score<T> {

    void init(Player... players);

    void increaseScore(Player player);

    Map<Player, T> getScore();
}
