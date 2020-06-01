package org.example.guardian.scrabble;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class DictionaryTest {

    @Test
    public void shouldReturnDictionaryWithWords() {
        Dictionary dictionary = new Dictionary();
        List<String> result = dictionary.getDictionary();

        assertThat(result.size(), is(greaterThan(2)));
    }
}