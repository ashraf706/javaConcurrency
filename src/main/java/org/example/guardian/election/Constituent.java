package org.example.guardian.election;

import java.util.ArrayList;
import java.util.List;

public class Constituent {
    private String name;
    private final List<Result> results;

    public Constituent(String name) {
        this.name = name;
        results = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addResult(Result result) {
        return results.add(result);
    }

    public List<Result> getResult() {
        return results;
    }
}
