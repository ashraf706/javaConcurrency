package org.example.guardian.gol;

import java.util.List;

public class BoardImpl implements Board {
    private final int size;
    private final int[][] position;

    public BoardImpl(int size) {
        this.size = size;
        position = new int[size][size];
    }

    @Override
    public List<Cell> getNeighbours(Cell cell) {
        return null;
    }
}
