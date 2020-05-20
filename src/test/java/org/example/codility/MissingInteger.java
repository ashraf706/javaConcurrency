package org.example.codility;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class MissingInteger {

    @Test
    public void missingInt() {
        assertEquals(5, solution(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(4, solution(new int[]{1, 2, 3}));
        assertEquals(1, solution(new int[]{-1, -3}));
    }

    int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        boolean flag = true;
        int num = 1;
        while (flag) {
            if (set.add(num)) {
                flag = false;
            } else {
                num++;
            }
        }

        return num;
    }
}
