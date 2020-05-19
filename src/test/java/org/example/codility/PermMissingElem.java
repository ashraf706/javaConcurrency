package org.example.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PermMissingElem {

    @Test
    public void missingElem() {
        assertEquals(4, solution(new int[]{2, 3, 1, 5}));
        assertEquals(8, solution(new int[]{2, 3, 1, 5, 4, 7, 6}));
        assertEquals(1, solution(new int[]{}));
        assertEquals(1, solution(new int[]{2}));
    }

    public int solution(int[] A) {
        int n = A.length + 1;
        int seriesSum = (n * (n + 1)) / 2;

        return seriesSum - Arrays.stream(A).sum();
    }
}
