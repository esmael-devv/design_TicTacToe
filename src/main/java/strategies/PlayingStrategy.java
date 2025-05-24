package strategies;

import models.Board;
import models.BoardCell;

public interface PlayingStrategy {

    BoardCell makeMove(Board board);
}
