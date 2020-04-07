package org.example.solidprinciple;

public class Square implements Shape {
    private int heightOrWidth;

    @Override
    public void draw() {

    }

    public int getHeightOrWidth() {
        return heightOrWidth;
    }

    public void setHeightOrWidth(int heightOrWidth) {
        this.heightOrWidth = heightOrWidth;
    }
}
