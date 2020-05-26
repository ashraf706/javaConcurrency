package org.example.codility;

import org.junit.Test;

import java.util.ArrayDeque;

import static org.junit.Assert.assertEquals;

public class Brackets {

    @Test
    public void brackets() {
        assertEquals(0, solution("("));
        assertEquals(0, solution(")"));
        assertEquals(0, solution("(]"));
        assertEquals(1, solution("()"));
        assertEquals(1, solution("{[()()]}"));
        assertEquals(0, solution("([)()]"));
        assertEquals(1, solution(""));
    }

    int solution(String S) {
        if(S.isEmpty()) return 1;

        String in = "({[";
        String out = ")}]";
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : S.toCharArray()) {
            if (in.indexOf(c) > -1) {
                stack.addFirst(c);
            } else if (out.indexOf(c) > -1) {
                if(stack.isEmpty()) {
                    return 0;
                }

                char element = stack.removeFirst();
                if ((c == ')' && element != '(') || (c == '}' && element != '{') || (c == ']' && element != '[')) {
                    return 0;
                }

            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
