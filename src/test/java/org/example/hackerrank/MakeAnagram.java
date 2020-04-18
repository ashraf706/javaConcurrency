package org.example.hackerrank;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MakeAnagram {

    @Test
    public void anagramTest() {
        int result;
        result = makeAnagram("abc", "ad");
        assertEquals(3, result);


        result = makeAnagram("cde", "dcf");
        assertEquals(2, result);

        result = makeAnagram("cde", "abc");
        assertEquals(4, result);

        result = makeAnagram("aa", "aa");
        assertEquals(0, result);

        result = makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
        assertEquals(30, result);


        result = makeAnagram("tttttttttttttttttttttttttttttttttttttsssssssssssssssss",
                "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        assertEquals(107, result);
    }

    static int makeAnagram(String a, String b) {
        int alphabet = 26;
        int aCount1[] = new int[alphabet];
        int bCount2[] = new int[alphabet];

        for (int i = 0; i < a.length() ; i++)
            aCount1[a.charAt(i) -'a']++;

        for (int i = 0; i < b.length() ; i++)
            bCount2[b.charAt(i) -'a']++;

        int result = 0;

        for (int i = 0; i < alphabet; i++)
            result += Math.abs(aCount1[i] - bCount2[i]);

        return result;
    }
}
