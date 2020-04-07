package org.example.solidprinciple;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeCreatorTest {
    @Test
    public void createRectangleTest() {
        ShapeCreator shapeCreator = new ShapeCreator();
        Rectangle rectangle = (Rectangle) shapeCreator.createShape("rectangle");
        assertNotNull(rectangle);

    }

    @Test
    public void createSquareTest() {
        ShapeCreator shapeCreator = new ShapeCreator();
        Shape square = shapeCreator.createShape("square");
        assertNotNull(square);
    }
}