package com.imc.assignment.domain;

import java.util.Objects;

public interface Player {

    PlayerMove getNextMove();

    String getPlayerName();

    void init();

    default boolean equalsDefault(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player that = (Player) o;
        return getPlayerName().equals(that.getPlayerName());
    }

    default int hashCodeDefault() {
        return Objects.hash(getPlayerName());
    }
}
