package org.example.guardian.gol;

import java.util.List;

public interface Board {
    List<Cell> getNeighbours(Cell cell);
}
