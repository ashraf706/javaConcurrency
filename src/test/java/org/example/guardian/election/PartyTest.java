package org.example.guardian.election;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PartyTest {

    @Test
    public void shouldReturnPartyNameFromCode() {
        Party ld = Party.LD;
        String result = ld.getName();
        assertThat(result, is("Liberal Democrats"));
    }
}
