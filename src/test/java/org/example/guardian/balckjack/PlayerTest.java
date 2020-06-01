package org.example.guardian.balckjack;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class PlayerTest {

    @Test
    public void playerShouldBeAbleToAddCard() {
        Player player = new Player("test player");
        boolean result = player.addCard(1);
        assertThat(result, equalTo(true));
    }

    @Test
    public void shouldBeAbleToReturnTotal() {
        Player player = new Player("test player");
        player.addCard(3);
        player.addCard(7);

        int result = player.getScore();
        assertThat(result, equalTo(10));
    }
}