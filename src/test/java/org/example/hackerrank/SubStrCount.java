package org.example.hackerrank;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SubStrCount {

    @Test
    public void substrCountTest() {
        String str = "";
        long result = -1;
        str = "aaa";
        result = substrCount(str.length(), str);
        assertEquals(6, result);

        str = "abac";
        result = substrCount(str.length(), str);
        assertEquals(5, result);

        str = "asasd";
        result = substrCount(str.length(), str);
        assertEquals(7, result);

    }

    static long substrCount(int n, String s) {
        long count = 0;

        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> occurrence = new ArrayList<>();

        countCharsOccurrence(s, chars, occurrence);

        count += byCombination(occurrence);
        count += byMatchingOccurrence(chars, occurrence);

        return count;
    }

    private static long byMatchingOccurrence(ArrayList<Character> chars, ArrayList<Integer> occurrence) {
        int count = 0;
        for (int i = 1; i < occurrence.size() - 1; i++) {
            if (occurrence.get(i) == 1 && chars.get(i - 1) == chars.get(i + 1)) {
                count += Math.min(occurrence.get(i - 1), occurrence.get(i + 1));
            }
        }
        return count;
    }

    private static long byCombination(ArrayList<Integer> occurrence) {
        return occurrence.stream().map(i -> (i * (i + 1)) / 2).mapToInt(Integer::intValue).sum(); //todo understand
    }

    public static void countCharsOccurrence(String s, ArrayList<Character> chars, ArrayList<Integer> occurrence) {
        char[] str = s.toCharArray();
        char previous = '?';
        int index = -1;
        int count = 0;
        for (char c : str) {
            if (c != previous) {
                count = 1;
                index++;
                previous = c;
                chars.add(c);
                occurrence.add(index, count);
            } else {
                occurrence.remove(index);
                occurrence.add(index, ++count);
            }
        }
    }

    @Test
    public void testCountCharsOccurrence() {
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> occurrence = new ArrayList<>();

        countCharsOccurrence("aaa", chars, occurrence);

        assertEquals(new Character('a'), chars.get(0));
        assertEquals(new Integer(3), occurrence.get(0));
    }

    @Test
    public void testCountCharsOccurrence1() {
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> occurrence = new ArrayList<>();

        countCharsOccurrence("aaabb", chars, occurrence);

        assertEquals(new Character('b'), chars.get(1));
        assertEquals(new Integer(2), occurrence.get(1));
    }
}
