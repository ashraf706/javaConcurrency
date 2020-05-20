package org.example.codility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FrogRiverOne {

    @Test
    public void frogRiver() {
        assertEquals(6, solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        assertEquals(0, solution(1, new int[]{1}));
    }

    int solution(int X, int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                set.add(A[i]);
                if (set.size() == X) {
                    return i;
                }
            }
        }

        return -1;
    }

    int solution1(int X, int[] A) {
        ArrayList<Integer> steps = new ArrayList<>();
        for (int i = 1; i <= X; i++) {
            steps.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                steps.remove(Integer.valueOf(A[i]));
                if (steps.isEmpty()) {
                    return i;
                }
            }

        }
        return -1;
    }

    int solution2(int X, int[] A) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X) {
                if (map.get(A[i]) != null) {
                    List<Integer> lst = map.get(A[i]);
                    lst.add(i);
                    map.put(A[i], lst);
                } else {
                    ArrayList<Integer> lst = new ArrayList<>();
                    lst.add(i);
                    map.put(A[i], lst);
                }
            }
        }

        if (map.keySet().size() < X) {
            return -1;
        }

        ArrayList<Integer> lowest = new ArrayList<>();
        map.forEach((k, v) -> lowest.add(v.stream().min(Integer::compareTo).get()));

        return lowest.stream().max(Integer::compareTo).get();
    }
}
