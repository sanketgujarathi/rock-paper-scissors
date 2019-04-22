package com.imc.assignment.service;

import com.imc.assignment.domain.Player;
import com.imc.assignment.domain.Score;

public interface Game {

    void init(Player... players);

    void play();

    Score getScore();


}
