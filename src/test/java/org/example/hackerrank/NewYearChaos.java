package org.example.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewYearChaos {

    @Test
    public void chaosTest() {
        //int result = minimumBribes(new int[]{2, 1, 5, 3, 4});
        int result = minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        assertEquals(7, result);
    }

    public int minimumBribes(int[] q) {
        int bribe = 0;
        boolean chaotic = false;
        for (int i = 0; i < q.length; i++) {
            if (chaotic = isTooChaotic(q, i)) {
                break;
            }

            for (int j = Math.max(0, q[i] - 2); j < i; j++)
                if (isBribed(q[j], q[i]))
                    bribe++;
        }

        printResult(chaotic, bribe);
        return bribe;
    }

    public static boolean isBribed(int j, int i) {
        return j > i;
    }

    public static boolean isTooChaotic(int[] q, int index) {
        return q[index] - (index + 1) > 2;
    }

    public static void printResult(boolean chaotic, int bribe) {
        if (chaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribe);
        }
    }
}
