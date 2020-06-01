package org.example.guardian.gol;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BoardTest {

    @Mock
    Board board;

    @Mock
    Cell cell;

    @Test
    public void boardShouldReturnNeighbourForACell() {
        ArrayList<Cell> neighbours = new ArrayList<>();
        neighbours.add(cell);
        Board board = new BoardImpl(3);

        when(board.getNeighbours(any())).thenReturn(neighbours);

        List<Cell> result = board.getNeighbours(cell);

        assertEquals(1, result.size());
    }
}
