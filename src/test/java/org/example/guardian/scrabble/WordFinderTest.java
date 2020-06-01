package org.example.guardian.scrabble;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class WordFinderTest {

    @Test
    public void findAWord() {
        String given = "abcatohe";
        List<String> dictionary = Arrays.asList("cat","to","he", "bcat", "cag");
        ArrayList<String> result = new ArrayList<>();
        for(String s: dictionary){
                if(given.contains(s)){
                    result.add(s);
                }
        }

        assertThat(result.size(), is(4));
    }
}