package org.example.hackerrank;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MinimumSwap {

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
    }

    static int minimumSwaps(int[] arr) {
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
