package org.example.guardian.balckjack;

import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private final int[] distributedCard;

    public Deck() {
        this.distributedCard = new int[13];
    }

    public int getCard() {
        int num;
        boolean flag = true;

        do{
            num = ThreadLocalRandom.current().nextInt(2, 11 + 1);

            if(isNotDistributed(num)){
                updateDistribution(num);
                flag = false;
            }
        }while (flag);

        return num;
    }

    private boolean isNotDistributed(int num) {
        return distributedCard[num - 1] < 4;

    }

    private void updateDistribution(int num){
        distributedCard[num - 1] += 1;
    }

}
