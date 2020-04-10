package org.example.arrays;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ArrayTest {

    @Test
    public void arrayToSum() {
        int[] first = {1, 2, 3};

        int result = 0;

        for (int i = 0; i < first.length; i++) {
            result *= 10;
            result += first[i];
        }
        assertEquals(123, result);
    }

    @Test
    public void intToArrayOfChar() {
        int intValue = 1234;
        String str = Integer.toString(intValue);

        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result[i] = c;
        }

        char[] output = {'1', '2', '3', '4'};
        assertArrayEquals(output, result);

    }

    @Test
    public void intToArrayOfInt() {
        int intValue = 10234;
        String str = Integer.toString(intValue);

        int[] result = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result[i] = c - '0';
        }

        int[] output = {1, 0, 2, 3, 4};
        assertArrayEquals(output, result);

    }

    @Test
    public void charAtTest() {
        String str = "abcde";
        String intStr = Integer.toString(1234);

        assertEquals('3', intStr.charAt(2));
    }
}
