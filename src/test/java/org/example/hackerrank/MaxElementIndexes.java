package org.example.hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxElementIndexes {

    @Test
    public void maximumElementIndex() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);
        a.add(5);
        ArrayList<Integer> rotate = new ArrayList<>();
        rotate.add(6);
        rotate.add(9);
        //rotate.add(12);

        List<Integer> result = getMaxElementIndexes(a, rotate);
        assertEquals(3, (int) result.get(0));
        assertEquals(0, (int) result.get(1));

    }

    @Test
    public void maximumElementIndex1() {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);
        ArrayList<Integer> rotate = new ArrayList<>();
        rotate.add(0);
        rotate.add(2);


        List<Integer> result = getMaxElementIndexes(a, rotate);
        assertEquals(2, (int) result.get(0));
        assertEquals(0, (int) result.get(1));

    }

    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();

        for (int rotateCount : rotate) {
            List<Integer> rotatedArray = rotateList(rotateCount, new ArrayList<>(a));
            result.add(findLargestItemIndex(rotatedArray));
        }

        return result;
    }

    public static List<Integer> rotateList(int rotationCount, List<Integer> arr) {
        int head = 0;
        int tail = arr.size() - 1;
        for (int i = 0; i < rotationCount; i++) {
            arr.add(tail, arr.remove(head));
        }

        return arr;
    }

    public static int findLargestItemIndex(List<Integer> a) {
        int max = a.get(0);
        int index = 0;
        int maxItemIndex = 0;

        for (int i : a) {
            if (i > max) {
                max = i;
                maxItemIndex = index;
            }
            index++;
        }

        return maxItemIndex;
    }
}
