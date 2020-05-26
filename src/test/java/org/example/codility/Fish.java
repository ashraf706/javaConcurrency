package org.example.codility;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

public class Fish {

    @Test
    public void fish() {
        assertEquals(1, solution(new int[]{4}, new int[]{0}));
        assertEquals(1, solution(new int[]{4}, new int[]{1}));
        assertEquals(2, solution(new int[]{4, 5, 8}, new int[]{1, 0, 1}));
        assertEquals(2, solution(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    int solution(int[] A, int[] B) {
        ArrayDeque<Integer> down = new ArrayDeque<>();
        int lastSize;
        int aliveCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) down.addFirst(A[i]);
            else {
                while (!down.isEmpty()) {
                    lastSize = down.peekFirst();

                    if (lastSize > A[i]) {
                        break;
                    } else {
                        down.removeFirst();
                    }
                }
                if (down.isEmpty()) aliveCount++;
            }
        }
        return aliveCount + down.size();
    }
}
