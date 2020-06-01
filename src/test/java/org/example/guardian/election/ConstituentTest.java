package org.example.guardian.election;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConstituentTest {

    @Mock
    Result result;

    @Test
    public void shouldHaveName() {
        Constituent sut = new Constituent("Leyton");

        String name = sut.getName();

        assertThat(name, is("Leyton"));
    }

    @Test
    public void shouldBeAbleToAddResult() {
        when(result.getPartyName()).thenReturn("AAA");
        Constituent sut = new Constituent("Leyton");
        boolean status = sut.addResult(this.result);

        assertThat(status, is(true));

        List<Result> result = sut.getResult();
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getPartyName(), is("AAA"));

    }
}
