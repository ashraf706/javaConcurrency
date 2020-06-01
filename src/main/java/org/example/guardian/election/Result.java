package org.example.guardian.election;

public class Result {
    private final Party party;
    private final int count;

    public Result(Party party, int count) {
        this.party = party;
        this.count = count;
    }

    public String getPartyName() {
        return party.getName();
    }

    public int getVoteCount() {
        return count;
    }
}
