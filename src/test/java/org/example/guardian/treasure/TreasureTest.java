package org.example.guardian.treasure;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class TreasureTest {

    @Test
    public void someTest() {
        int[] treasures = new int[]{3,2,7,7,14,5,3,4,9,2};
        int sum = Arrays.stream(treasures).sum();
        assertThat(sum, is(56));
    }
}
