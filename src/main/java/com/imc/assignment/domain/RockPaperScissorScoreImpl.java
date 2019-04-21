package com.imc.assignment.domain;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.valueOf;
import static java.util.Arrays.stream;
import static java.util.function.Function.identity;

@Repository
public class RockPaperScissorScoreImpl implements Score {


    private Map<Player, Integer> scoreMap;

    public RockPaperScissorScoreImpl(Map<Player, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    @Override
    public void initScore(Player... players) {
        scoreMap = stream(players).collect(Collectors.toMap(identity(), v -> valueOf(0)));
    }

    @Override
    public void increaseScore(Player player) {
        scoreMap.computeIfPresent(player, (k,v) -> v+1);
    }

    @Override
    public Map<Player, Integer> getScore() {
        return scoreMap;
    }


}
