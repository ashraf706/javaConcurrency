package org.example.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogJmp {

    @Test
    public void frogJmp() {
        assertEquals(3, solution(10, 85, 30));
    }

    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int hops = distance / D;

        if (distance % D > 0) {
            hops += 1;
        }
        return hops;
    }
}
