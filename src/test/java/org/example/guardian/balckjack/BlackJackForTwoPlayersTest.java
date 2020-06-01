package org.example.guardian.balckjack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlackJackForTwoPlayersTest {

    @Test
    public void shouldBeAbleToStartAGame() {
        Player player = new Player("Sam");
        BlackJack blackJack = new BlackJackForTwoPlayers(new Deck(), player);

        blackJack.start();

        assertThat(player.getScore(), is(greaterThan(2)));
    }

    @Test
    public void checkWinnerBy21s() {
        Player player = mock(Player.class);
        when(player.getScore()).thenReturn(21);
        BlackJack blackJack = new BlackJackForTwoPlayers(new Deck(), player);
        blackJack.start();

        Player result = blackJack.checkWinner().get();

        assertThat(result, is(player));
    }

    @Test
    public void checkNoWinnerBy21s() {
        Player player = mock(Player.class);
        when(player.getScore()).thenReturn(10);
        BlackJack blackJack = new BlackJackForTwoPlayers(new Deck(), player);
        blackJack.start();

        Player result = blackJack.checkWinner().isPresent() ? blackJack.checkWinner().get() :  null;

        assertThat(result, nullValue());
    }
}