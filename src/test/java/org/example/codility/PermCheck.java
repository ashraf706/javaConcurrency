package org.example.codility;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class PermCheck {
    @Test
    public void permTest() {
        assertEquals(1, solution(new int[]{4, 1, 3, 2}));
        assertEquals(0, solution(new int[]{4, 1, 3}));
    }

    int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        return Collections.max(set) == A.length && set.size() == A.length ? 1 : 0;
    }
}
