package org.example.hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ArrayTest {

    @Test
    public void hourGlassTest() {
        int arr[][] = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };

        int arr7[][] = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };


        int result = hourglassSum(arr);
        assertEquals(-19, result);
    }

    private int hourglassSum(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        for(int i =1; i < 5; i++){
            for(int j = 1; j < 5; j++)
            {
                int top = i -1;
                int bottom = i + 1;
                int sum = arr[top][j-1]+ arr[top][j]+arr[top][j+1] + arr[i][j] + arr[bottom][j-1]+ arr[bottom][j]+arr[bottom][j+1];
                result.add(sum);
            }
        }

        Collections.sort(result);
        Collections.reverse(result);
        return result.get(0);
    }
}
