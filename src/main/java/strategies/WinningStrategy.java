package strategies;

import models.Board;
import models.GameSymbol;

public interface WinningStrategy {
    boolean checkWinner(Board board, GameSymbol symbol);
}
