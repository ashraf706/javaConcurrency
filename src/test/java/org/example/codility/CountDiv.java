package org.example.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountDiv {

    @Test
    public void countDiv() {
        assertEquals(3, solution(5, 11, 2));
    }

    int solution(int A, int B, int K) {
        return (B / K) - (A / K) + (A % K == 0 ? 1 : 0);
    }
}
