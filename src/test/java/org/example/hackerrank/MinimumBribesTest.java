package org.example.hackerrank;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MinimumBribesTest {

    @Test
    public void sortedArraySwap() {
        int[] sorted = {1, 2, 3, 4};
        int totalSwap = 0;
        for (int position = 0; position < sorted.length; position++) {
            int element = sorted[position];
            int originalPosition = element - 1;
            int elementSwappedCount = Math.abs(position - originalPosition);
            totalSwap += elementSwappedCount;
        }

        assertEquals(0, totalSwap / 2);
    }

    @Test
    public void unsortedArraySwap() {
        //int[] q = {5, 1, 2, 3, 7, 8, 6, 4};
        //int[] q = {2,5,1,3,4};
        //int[] q = {1, 2, 5, 3, 4, 7, 8, 6};
        int[] q = {1, 2, 5, 3, 7, 8, 6, 4};
        //int[]q = {5, 1, 2, 3, 7, 8, 6, 4};

        int totalSwap = 0;
        boolean chaotic = false;
        for (int position = 0; position < q.length; position++) {
            int element = q[position];
            int originalPosition = element - 1;
            int elementSwappedCount = Math.abs(position - originalPosition);
            if ((position < originalPosition) && (elementSwappedCount > 2)) {
                chaotic = true;
                break;
            }
            totalSwap += elementSwappedCount;
        }
        if (chaotic) {
            String too_chaotic = "Too chaotic";
            assertEquals(too_chaotic, too_chaotic);
            System.out.println(too_chaotic);
        } else {
            System.out.println(totalSwap / 2);
            assertEquals(7, totalSwap / 2);
        }
    }


    @Test
    public void someTest() {
        int result = minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        assertEquals(7, result);

        result = minimumBribes(new int[]{2, 1, 5, 3, 4});
        assertEquals(3, result);

        result = minimumBribes(new int[]{2, 5, 1, 3, 4});
        assertEquals(-1, result);
        ;
    }

    private int minimumBribes(int[] q) {
        int[] result = new int[q.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }

        int swapCount = 0;
        boolean chaos;

        do {
            chaos = doSwap(q, result);
            swapCount++;
        } while (!chaos && !Arrays.equals(result, q));

        if (chaos) {
            System.out.println("Too Chaotic");
            return -1;
        } else {
            System.out.println(swapCount);
            return swapCount;
        }
    }

    private boolean doSwap(int[] queue, int result[]) {
        for (int position = 0; position < result.length; position++) {
            int element = result[position];
            int elementInQueue = queue[position];

            if (element != elementInQueue) {
                int indexInResult = indexOfIntArray(result, elementInQueue);
                if (position < indexInResult && (Math.abs(position - indexInResult) > 2)) {
                    return true;
                }
                int temp = result[indexInResult];
                result[indexInResult] = result[indexInResult - 1];
                result[indexInResult - 1] = temp;
                break;
            }
        }
        return false;
    }

    public static int indexOfIntArray(int[] array, int key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }
}