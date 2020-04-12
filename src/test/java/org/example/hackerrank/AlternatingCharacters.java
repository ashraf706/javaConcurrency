package org.example.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlternatingCharacters {

    @Test
    public void alternatingCharTest() {
        String s = "AABAAB";
        int result = alternatingCharacters(s);

        assertEquals(2, result);
    }

    static int alternatingCharacters(String s) {
        int counter = 0;
        char lastChar = '1';
        char[] array = s.toCharArray();

        for (char c : array) {
            if (lastChar == c) {
                counter++;
            } else {
                lastChar = c;
            }
        }

        return counter;

    }

}
