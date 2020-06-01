package org.example.guardian.balckjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Integer> cards;

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public boolean addCard(int number){
        return cards.add(number);
    }

    public int getScore(){
         return cards.stream().mapToInt(i -> i).sum();
    }


}
