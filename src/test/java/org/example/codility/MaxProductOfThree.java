package org.example.codility;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class MaxProductOfThree {

    @Test
    public void sort() {
        assertEquals(125, solution(new int[]{-5, 5, -5, 4}));
        assertEquals(0, solution(new int[] {}));
        assertEquals(60, solution(new int[] {-3,1,2,-2,5,6}));
    }

    int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        Arrays.sort(A);

        int product1, product2, product3, product4 = 0;
        int length = A.length;

        product1 = A[0] * A[1] * A[2]; //first 3 elements
        product2 = A[length - 3] * A[length - 2] * A[length - 1]; //last 3 elements
        product3 = A[0] * A[1] * A[length - 1]; //first 2 and last element
        product4 = A[0] * A[length - 2] * A[length - 1]; //first and last 2 elements

        int max1 = Math.max(product1, product2);
        int max2 = Math.max(product3, product4);

        return Math.max(max1, max2);
    }
}
