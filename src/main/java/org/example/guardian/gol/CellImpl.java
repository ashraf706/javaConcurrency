package org.example.guardian.gol;

public class CellImpl implements Cell {
    private Life state;
    private final int[][] position;

    public CellImpl(int[][] position) {
        this.position = position;
    }

    @Override
    public Life getState() {
        return null;
    }
}
