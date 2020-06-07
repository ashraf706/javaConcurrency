package org.example.codility;

import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

public class Distinct {

    @Test
    public void distinctTest() {
        assertEquals(0, solution(new int[] {}));
        assertEquals(3, solution(new int[] {2,1,1,2,3,1}));
    }

    int solution(int[] A){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
        }

        return set.size();
        //return Arrays.stream(A).boxed().collect(Collectors.toSet()).size();
    }
}
