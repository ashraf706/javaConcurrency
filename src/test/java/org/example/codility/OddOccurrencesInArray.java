package org.example.codility;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OddOccurrencesInArray {
    @Test
    public void oddOccurrence() {
        assertEquals(7, solution(new int[]{9, 20, 3, 5, 9, 3, 9, 20, 7, 9, 5}));
        //assertEquals(7, solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        int elem = 0;

        for (int i = 0; i < A.length; i++) {
            elem ^= A[i];
        }
        return elem;
    }

    public int solution1(int[] A) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (lst.contains(A[i])) {
                lst.remove(Integer.valueOf(A[i]));
            } else {
                lst.add(A[i]);
            }
        }
        return lst.size() > 0 ? lst.get(0) : 0;
    }
}
