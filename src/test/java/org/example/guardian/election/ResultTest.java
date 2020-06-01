package org.example.guardian.election;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResultTest {


    private Result result;

    @Before
    public void setUp() {
        result = new Result(Party.L, 500);
    }

    @Test
    public void shouldReturnPartyName() {
        assertThat(result.getPartyName(), is("Labour"));
    }

    @Test
    public void shouldReturnVoteCount() {
        assertThat(result.getVoteCount(), is(500));
    }
}