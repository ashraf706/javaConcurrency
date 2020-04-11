package org.example.hackerrank;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static junit.framework.TestCase.assertEquals;

public class MinimumSwap2 {

    @Test
    public void minimumSwapWithArrayIndex() {
        int result = minimumSwapsWithArrayIndex(new int[]{4, 3, 1, 2});
        assertEquals(3, result);

        result = minimumSwapsWithArrayIndex(new int[]{7, 1, 3, 2, 4, 5, 6});
        assertEquals(5, result);

        result = minimumSwapsWithArrayIndex(new int[]{2, 3, 4, 1, 5});
        assertEquals(3, result);

        result = minimumSwapsWithArrayIndex(new int[]{1, 3, 5, 2, 4, 6, 7});
        assertEquals(3, result);
    }

    @Test
    public void minimumSwap() {
        int result = minimumSwaps(new int[]{4, 3, 1, 2});
        assertEquals(3, result);
        result = minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6});
        assertEquals(5, result);

        result = minimumSwaps(new int[]{2, 3, 4, 1, 5});
        assertEquals(3, result);

        result = minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7});
        assertEquals(3, result);

        int[] bigArray = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32
                , 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};
        result = minimumSwaps(bigArray);
        assertEquals(46, result);

    }

    static int minimumSwaps(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        Vector<Integer> vec = new Vector<>();

        //add arr element to the map
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                vec.add(arr[i]);
                map.put(i, arr[i]);
            }

        }
        int swapCount = 0;
        for (int position = 0; position < vec.size(); position++) {
            int item = vec.get(position);
            if (map.get(item - 1) != item) {
                int temp = map.get(item - 1);
                Integer currentPosition = getKey(map, item);
                map.put(item - 1, item);
                map.put(currentPosition, temp);
                swapCount++;
            }
        }
        return swapCount;
    }

    public static Integer getKey(Map<Integer, Integer> map, int value) {
        return map.entrySet().stream().filter(entry -> entry.getValue() == value).map(Map.Entry::getKey).findFirst().get();
    }

    static int minimumSwapsWithArrayIndex(int[] arr) {
        int count = 0;
        int index = 0;
        do {
            index = swap(index, arr, arr[index]);
            if (index == 0) {
                count++;
            }

        } while (index != arr.length - 1);

        return count;
    }

    static int swap(int index, int[] arr, int selectedItem) {
        for (int i = index; i < arr.length; i++) {
            int currentItem = arr[i];
            if (currentItem > selectedItem) {
                if (index + 1 == i) {
                    //item in the right position
                    return i;
                }
                //swap
                arr[index] = arr[i - 1];
                arr[i - 1] = selectedItem;
                return 0;
            } else if (i == (arr.length - 1)) { //last element
                //this means first element is the biggest element in the array
                //swap the last element with the first element
                arr[0] = arr[i];
                arr[i] = selectedItem;
                return 0;
            }
        }
        return arr.length;
    }

}
