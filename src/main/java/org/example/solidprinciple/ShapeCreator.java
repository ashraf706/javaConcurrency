package org.example.solidprinciple;

public class ShapeCreator {
    public Shape createShape(String  type) {
        if(type.equals("rectangle")) {
            return new Rectangle();
        }
        return new Square();
    }

}
