package org.example.guardian.balckjack;

import java.util.Optional;

public class BlackJackForTwoPlayers implements BlackJack {
    public static final int BLACK_JACK = 21;
    private final Player dealer;
    private final Player player;
    private final Deck deck;

    public BlackJackForTwoPlayers(Deck deck, Player player) {
        dealer = new Player("Dealer");
        this.player = player;
        this.deck = deck;
    }

    @Override
    public void start() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.getCard());
            player.addCard(deck.getCard());

            dealer.addCard(deck.getCard());
            dealer.addCard(deck.getCard());
        }
    }

    @Override
    public Optional<Player> checkWinner() {
        if(player.getScore() == BLACK_JACK){
            return Optional.of(player);
        }
        if(dealer.getScore() == BLACK_JACK){
            return Optional.of(dealer);
        }

        return Optional.empty();
    }
}
