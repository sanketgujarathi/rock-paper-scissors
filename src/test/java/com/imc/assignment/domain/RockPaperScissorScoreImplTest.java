package com.imc.assignment.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorScoreImplTest {

    private Score rockPaperScissorScore;

    @Before
    public void setUp() {
        this.rockPaperScissorScore = new RockPaperScissorScoreImpl();
    }

    @Test
    public void testIncreaseScore() {

        Player player = new CpuPlayerImpl();
        rockPaperScissorScore.init(player);
        rockPaperScissorScore.increaseScore(player);
        assertThat(rockPaperScissorScore.getScore().get(player), is(1));
        rockPaperScissorScore.increaseScore(player);
        assertThat(rockPaperScissorScore.getScore().get(player), is(2));
    }

}