package com.imc.assignment.service;

import com.imc.assignment.domain.Player;
import com.imc.assignment.domain.Score;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;

import static com.imc.assignment.domain.PlayerMove.*;
import static org.mockito.Mockito.*;

public class RockPaperScissorGameImplTest {

    @Mock
    private Player player1;

    @Mock
    private Player player2;

    @Mock
    private Score score;

    private Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        game = new RockPaperScissorGameImpl(player1,player2, score);

    }

    @Test
    public void testInit() {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        game.init();
        verify(player1, times(1)).init();
        verify(player2, times(1)).init();
        verify(score, times(1)).init(player1, player2);

    }

    @Test
    public void testPlayWhenPlayer1Wins() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        game.init();
        when(player1.getNextMove()).thenReturn(ROCK);
        when(player2.getNextMove()).thenReturn(SCISSORS);
        game.play();
        verify(player1, times(1)).getNextMove();
        verify(player2, times(1)).getNextMove();
        verify(score, times(1)).increaseScore(player1);
        verify(score, never()).increaseScore(player2);
    }

    @Test
    public void testPlayWhenPlayer2Wins() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        game.init();
        when(player1.getNextMove()).thenReturn(PAPER);
        when(player2.getNextMove()).thenReturn(SCISSORS);
        game.play();
        verify(player1, times(1)).getNextMove();
        verify(player2, times(1)).getNextMove();
        verify(score, never()).increaseScore(player1);
        verify(score, times(1)).increaseScore(player2);
    }

    @Test
    public void testPlayWhenThereIsATie() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        game.init();
        when(player1.getNextMove()).thenReturn(PAPER);
        when(player2.getNextMove()).thenReturn(PAPER);
        game.play();
        verify(player1, times(1)).getNextMove();
        verify(player2, times(1)).getNextMove();
        verify(score, never()).increaseScore(player1);
        verify(score, never()).increaseScore(player2);
    }

    @Test
    public void testPlayForMultipleRounds() {
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        game.init();
        game.play();
        verify(player1, times(3)).getNextMove();
        verify(player2, times(3)).getNextMove();
    }

}