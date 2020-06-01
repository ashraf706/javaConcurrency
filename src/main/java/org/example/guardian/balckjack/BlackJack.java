package org.example.guardian.balckjack;

import java.util.Optional;

public interface BlackJack {
    void start();
    Optional<Player> checkWinner();
}
