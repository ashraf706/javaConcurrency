package org.example.guardian.election;

public enum Party {
    C("C", "Conservative"), L("L", "Labour"), UKIP("UKIP","UKIP" ),LD ("LD","Liberal Democrats");

    private final String code;
    private final String name;

    Party(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
