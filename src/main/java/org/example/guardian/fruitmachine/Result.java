package org.example.guardian.fruitmachine;

public class Result {
    private String displaySlot;
    private double amount;

    public Result(String displaySlot, double amount) {
        this.displaySlot = displaySlot;
        this.amount = amount;
    }

    public String getDisplaySlot() {
        return displaySlot;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Result{" +
                "displaySlot='" + displaySlot + '\'' +
                ", amount=" + amount +
                '}';
    }
}
