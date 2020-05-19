package org.example.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibrium {

    @Test
    public void tapeEquilibrium() {
        assertEquals(1, solution(new int[]{3, 1, 2, 4, 3}));

        System.out.println(solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(solution(new int[]{3, 1}));
        System.out.println(solution(new int[]{-3, -1, -2, -4, -3}));
        System.out.println(solution(new int[]{-3, -1, -2, 4, 3}));

    }

    int solution(int[] A) {
        int total = 0;

        for (int j = 0; j < A.length; j++) {
            total += A[j];
        }
        int diff = Integer.MAX_VALUE;
        int left = 0;
        int right;

        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right = total - left;
            diff = Math.min(diff, Math.abs(left - right));

        }
        return diff;
    }

}
