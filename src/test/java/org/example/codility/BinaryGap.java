package org.example.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryGap {

    @Test
    public void binaryGapTest() {
        assertEquals(2, solution(9));
        assertEquals(4, solution(529));
        assertEquals(0, solution(15));
        assertEquals(0, solution(32));
        assertEquals(5, solution(1041));
    }

    private int solution(int number) {
        String str = Integer.toBinaryString(number);
        int maxLength = 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            System.out.print(c);
            if ((c - '0') == 1) {
                if (count > maxLength) {
                    maxLength = count;
                }
                count = 0;
            } else {
                count++;
            }
        }

        return maxLength;
    }
}
