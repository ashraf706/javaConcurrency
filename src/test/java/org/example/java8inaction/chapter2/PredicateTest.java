package org.example.java8inaction.chapter2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PredicateTest {
    private List<Apple> apples;
    private List<Orange> oranges;

    @Before
    public void setUp() throws Exception {
        apples = Arrays.asList(new Apple("green", 20), new Apple("red", 15));
        oranges = Arrays.asList(new Orange("clementine", 15), new Orange("satsuma", 20));
    }

    @Test
    public void testApplePredicate() {
        List<Apple> result = getAppleFromInventory(apples, (apple -> apple.getColor().equals("green")));
        assertEquals(1, result.size());
        assertEquals("green", result.get(0).getColor());
    }

    @Test
    public void testOrangePredicate() {
        List<Orange> result = getOrangeFromInventory(oranges, (orange -> orange.getType().equals("clementine")));
        assertEquals(1, result.size());
        assertEquals("clementine", result.get(0).getType());
    }

    @Test
    public void testFruitPredicate() {
        List<Orange> result = getFruitFromInventory(oranges, (orange -> orange.getType().equals("clementine")));
        assertEquals(1, result.size());
        assertEquals("clementine", result.get(0).getType());
    }

    private <T> List<T> getFruitFromInventory(List<T> inventory, Predicate<T> predicate) {
        return inventory
                .stream()
                .filter(predicate::test)
                .collect(Collectors.toList());
    }

    private List<Apple> getAppleFromInventory(List<Apple> inventory, ApplePredicate predicate) {
        return inventory
                .stream()
                .filter(apple -> predicate.test(apple))
                .collect(Collectors.toList());
    }

    private List<Orange> getOrangeFromInventory(List<Orange> inventory, OrangePredicate predicate) {
        return inventory
                .stream()
                .filter(orange -> predicate.test(orange))
                .collect(Collectors.toList());
    }
}