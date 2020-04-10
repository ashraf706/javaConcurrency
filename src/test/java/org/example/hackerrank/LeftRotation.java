package org.example.hackerrank;

import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertArrayEquals;

public class LeftRotation {
    @Test
    public void leftRotation() {
        int[] ar = {1, 2, 3, 4, 5};
        int[] output = {5, 1, 2, 3, 4};

        int[] result = rotateLeft(ar, 4);
        assertArrayEquals(result, output);

    }

    static int[] rotateLeft(int[] a, int d) {
        Vector<Integer> input = new Vector<>();

        for (int i = 0; i < a.length; i++) {
            input.add(a[i]);
        }

        for (int j = 1; j <= d; j++) {
            int firstElement = input.remove(0);
            input.add(firstElement);
        }

        return input.stream().mapToInt(i -> i).toArray();
    }
}
