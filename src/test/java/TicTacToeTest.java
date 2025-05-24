import models.Board;
import models.BoardCell;
import models.Game;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    @Test
    public void testCreateGame() {
        //Board board = new Board();
        //Game game = new Game();
    }

    @Test
    public void testCreateBoard() {
        Board board = new Board(3);

         int rowsize = board.getCells().get(0).size();
        //List<BoardCell> firstRow = board.getCells().get(0);
        //int rowsize = firstRow.size();
        assertEquals(3, rowsize,
                "if the contructor of board is called with n, it should create n cells"
        );

        int colsize = board.getCells().get(0).size();
        assertEquals(3,colsize,
                "if the contructor of board is called with n, it should create n cells"
        );



    }
}
