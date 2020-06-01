package org.example.guardian.scrabble;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    List<String> dictionary;

    public Dictionary() {
        InputStream resourceAsStream = getClass().getResourceAsStream("/twl06.txt");
        dictionary = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));
        dictionary = br.lines().collect(Collectors.toList());
    }

    public List<String> getDictionary() {
        return dictionary;
    }
}
