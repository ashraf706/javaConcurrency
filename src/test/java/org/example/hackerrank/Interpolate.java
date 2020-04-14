package org.example.hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Interpolate {

    @Test
    public void first() {
        int n = 25;
        List<Integer> instances = new ArrayList<>();
        instances.add(10);
        instances.add(25);
        instances.add(50);
        instances.add(100);
        instances.add(500);

        List<Float> price = new ArrayList<>();
        price.add((float) 2.46);
        price.add((float) 2.58);
        price.add((float) 2.0);
        price.add((float) 2.25);
        price.add((float) 3.0);

        String result = interpolate(n, instances, price);
        assertEquals("2.58", result);
    }

    public static String interpolate(int n, List<Integer> instances, List<Float> price) {
        int index = findInstanceIndex(instances, n);
        return getPriceForIndex(price, index);
    }

    public static int findInstanceIndex(List<Integer> instances, int n) {
        int index = -1;
        for (int item : instances) {
            index++;
            if (item == n) {
                break;
            }
        }

        return index;
    }

    public static String getPriceForIndex(List<Float> price, int index) {
        return index != -1 ? Float.toString(price.get(index)) : "";
    }
}
