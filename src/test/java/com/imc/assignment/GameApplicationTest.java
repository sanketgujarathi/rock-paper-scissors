package com.imc.assignment;


import com.imc.assignment.domain.CpuPlayerImpl;
import com.imc.assignment.domain.RockPaperScissorScoreImpl;
import com.imc.assignment.domain.Score;
import com.imc.assignment.service.Game;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GameApplicationTest {

    @Mock
    private Game game;

    private GameApplication gameApplication;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.gameApplication = new GameApplication(game);
    }

    @Test
    public void testRunMethod() {
        Score score = new RockPaperScissorScoreImpl();
        score.init(new CpuPlayerImpl());
        when(game.getScore()).thenReturn(score);

        gameApplication.run("args");

        verify(game, times(1)).init();
        verify(game, times(1)).play();
        verify(game, times(1)).getScore();
    }
}