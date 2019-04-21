package com.imc.assignment.domain;

import java.util.Map;

public interface Score {

    void initScore(Player... players);

    void increaseScore(Player player);

    Map<Player, Integer> getScore();
}
