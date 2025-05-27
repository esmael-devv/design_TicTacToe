package strategies;

import models.Board;
import models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {

    @Override
    public BoardCell makeMove(Board board) {

        // Output -> A cell from list of available cell

        //get a list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        //generate a randon index for cells
        int randomIndex = (int) (Math.random() * emptyCells.size());
        // Return the random celll
        BoardCell boardCell = emptyCells.get(randomIndex);
        return new BoardCell(boardCell.getRow(), boardCell.getCol());
    }
}
