package org.example.udemy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Prime {

    @Test
    public void testPrime() {
        int n = 13;
        String result = "prime";
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                result = " not prime";
            }
        }

        assertEquals("prime", result);
    }

    @Test
    public void strToNum() {
        String str = "123";
        int base = 10;
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            int character = str.charAt(i) - '0';
            num = base * num + character;
        }

        assertEquals(123, num);
    }
}
