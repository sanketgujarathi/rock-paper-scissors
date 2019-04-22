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

        assertFalse("Rock does not beat paper", ROCK.beats(PAPER));
        assertFalse("Paper does not beat scissors", PAPER.beats(SCISSORS));
        assertFalse("Scissors does not beat rock", SCISSORS.beats(ROCK));
    }

    @Test
    public void testBeatsWhenTie() {

        assertFalse(ROCK.beats(ROCK));
        assertFalse(PAPER.beats(PAPER));
        assertFalse(SCISSORS.beats(SCISSORS));
    }


}