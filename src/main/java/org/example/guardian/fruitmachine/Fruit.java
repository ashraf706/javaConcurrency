package org.example.guardian.fruitmachine;

public enum Fruit {
    Black("**black**"), Blue("**blue**"),
    Green("**green**"), Yellow("**yellow**");

    private final String color;

    public String getColor() {
        return color;
    }

    Fruit(String color) {
        this.color = color;
    }
}
