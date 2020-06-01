package org.example.guardian.fruitmachine;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class SlotMachine {
    private double money;
    private int[] spinOutcome = new int[4];
    private double currentAmount;

    public SlotMachine(double money) {
        this.money = money;
    }

    public Result spin(double amount) {
        currentAmount = amount;
        money += amount;
        return new Result(execute(), winningAmount());
    }

    private String execute() {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int index = ThreadLocalRandom.current().nextInt(0, 4);
            spinOutcome[i] = index;
            stringBuilder.append(Fruit.values()[index].getColor());
        }

        return stringBuilder.toString();
    }

    private double winningAmount() {
        if (isJackpot()) {
            return money;
        }
        if(differentColor()){
            return money/2;
        }
        if(getConsecutive()){
            return currentAmount * 5;
        }
        return 0;
    }

    private boolean differentColor() {
        HashSet<Integer> set = getOutcomeType();

        return set.size() == 4;
    }

    private boolean isJackpot() {
        HashSet<Integer> set = getOutcomeType();
        return set.size() == 1;
    }

    private HashSet<Integer> getOutcomeType() {
        HashSet<Integer> set = new HashSet<>();

        for (int i : spinOutcome) {
            set.add(i);
        }
        return set;
    }

    private boolean getConsecutive(){
        int prev = -1;
        for(int i: spinOutcome){
            if(prev == i){
                return true;
            }
            else{
                prev = i;
            }
        }

        return false;
    }
}
