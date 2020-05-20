package org.example.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MaxCounters {
    @Test
    public void maxCounters() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
    }

    int[] solution(int N, int[] A) {
        int[] arr = new int[N];

        int max = 0;

        for (int i = 0; i < A.length; i++) {
            int x = A[i];

            if (x > N) {
                Arrays.fill(arr, max);
            } else {
                int inc = arr[x - 1] + 1;
                arr[x - 1] = inc;
                if (inc > max) {
                    max = inc;
                }
            }
        }
        return arr;
    }

    int[] solution1(int N, int[] A) {
        int[] arr = new int[N];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            int x = A[i];

            for (int j = 1; j <= arr.length; j++) {
                if (j == x) {
                    int inc = arr[j - 1] + 1;
                    arr[j - 1] = inc;
                    if (inc > max) {
                        max = inc;
                    }
                } else if (x > N) {
                    arr[j - 1] = max;
                }
            }
        }
        return arr;
    }
}
