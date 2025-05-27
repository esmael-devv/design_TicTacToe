package strategies;

import models.Board;
import models.BoardCell;
import models.GameSymbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Board board, GameSymbol symbol) {
        for(List<BoardCell> rows : board.getCells()){
            boolean isWinner = true;
            for(BoardCell cell : rows){
                if(cell.getSymbol() != symbol) {
                    isWinner = false;
                    break;
                }
            }
            if(isWinner)
                return true;
        }
        return false;
    }
}
