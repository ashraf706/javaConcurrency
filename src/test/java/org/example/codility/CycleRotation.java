package org.example.codility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class CycleRotation {

    @Test
    public void cycleTest() {
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution2(new int[]{3, 8, 9, 7, 6}, 3));
        assertArrayEquals(new int[]{1, 2, 3, 4}, solution2(new int[]{1, 2, 3, 4}, 4));
    }

    public int[] solution(int[] A, int K) {
        List<Integer> lst = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < K; i++) {
            lst = rotate(lst);
        }

        return lst.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> rotate(List<Integer> lst) {
        Integer lastElement = lst.remove(lst.size() - 1);
        ArrayList<Integer> result = new ArrayList<>();

        result.add(lastElement);
        result.addAll(lst);
        return result;
    }

    //=================================================================================

    public int[] solution2(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            shift(A);
        }

        return A;
    }

    private void shift(int[] A) {
        int length = A.length;
        int lastIndex = length - 1;
        int lastElement = A[lastIndex];

        for (int i = lastIndex; i > 0; i--) {
            A[i] = A[i - 1];
        }

        A[0] = lastElement;

    }
}
