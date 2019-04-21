package com.imc.assignment.service;

import com.imc.assignment.domain.Score;

public interface Game {

    void init();

    void play();

    Score getScore();


}
