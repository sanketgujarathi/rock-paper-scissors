package com.imc.assignment.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RockPaperScissorScoreImpl implements Score<Integer> {


    private Map<Player, Integer> scoreMap = new HashMap<>();

    @Override
    public void init(Player player) {
        scoreMap.put(player, 0);
    }

    @Override
    public void increaseScore(Player player) {
        scoreMap.computeIfPresent(player, (k, v) -> v + 1);
    }

    @Override
    public Map<Player, Integer> getScore() {
        return scoreMap;
    }


}
