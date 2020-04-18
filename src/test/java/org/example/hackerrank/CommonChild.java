package org.example.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonChild {

    @Test
    public void commonChildTest() {
        int result;
        result = commonChild("ABCD", "ABDC");
        assertEquals(3, result);

        result = commonChild("HARRY", "SALLY");
        assertEquals(2, result);
    }

    static int commonChild(String s1, String s2) {
        int[][] match = new int[s1.length() + 1][s2.length() + 1];
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    match[i][j] = 0;
                } else if (s1Arr[i - 1] == s2Arr[j - 1]) {
                    match[i][j] = 1 + match[i - 1][j - 1];
                } else {
                    match[i][j] = Math.max(match[i][j - 1], match[i - 1][j]);
                }
            }
        }

        return match[s1.length()][s2.length()];
    }
}
