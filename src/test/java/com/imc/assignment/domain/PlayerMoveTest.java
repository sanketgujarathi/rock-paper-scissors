package com.imc.assignment.domain;


import org.junit.Test;

import static com.imc.assignment.domain.PlayerMove.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayerMoveTest {

    @Test
    public void testBeatsForBasicScenarios() {

        assertTrue("Rock should beat scissors", ROCK.beats(SCISSORS));
        assertTrue("Paper should beat rock", PAPER.beats(ROCK));
        assertTrue("Scissors should beat paper", SCISSORS.beats(PAPER));
    }

    @Test
    public void testBeathsWhenTie() {

        assertFalse("Rock should beat scissors", ROCK.beats(ROCK));
        assertFalse("Paper should beat rock", PAPER.beats(PAPER));
        assertFalse("Scissors should beat paper", SCISSORS.beats(SCISSORS));
    }


}