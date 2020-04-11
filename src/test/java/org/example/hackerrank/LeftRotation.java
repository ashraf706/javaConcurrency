package org.example.hackerrank;

import org.junit.Test;

import java.util.Vector;
import java.util.stream.IntStream;

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
        Vector<Integer> input = createVectorFrom(a);
        rotate(input, d);

        return vectorToIntArray(input);
    }

    public static void rotate(Vector<Integer> input, int times) {
        int first = 0;
        IntStream.rangeClosed(1, times)
                .map(any -> input.remove(first))
                .forEach(input::add);

        //for representation of range
        /*for (int j = 1; j <= d; j++) {
            int firstItem = input.remove(first);
            input.add(firstItem);
        }*/
    }

    public static Vector<Integer> createVectorFrom(int[] a) {
        Vector<Integer> vector = new Vector<>();

        for (int value : a) {
            vector.add(value);
        }

        return vector;
    }

    public static int[] vectorToIntArray(Vector<Integer> vector) {
        return vector.stream().mapToInt(i -> i).toArray();
    }
}
