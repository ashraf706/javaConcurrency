package org.example.guardian.balckjack;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


public class DeckTest {

    @Test
    public void shouldBeAbleToReturnARandomCard() {
        Deck deck = new Deck();
        int card = deck.getCard();
        assertThat(card, allOf(greaterThan(1), lessThan(12)));
    }
}