import models.*;
import org.junit.jupiter.api.Test;
import strategies.RandomPlayingStrategy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private static final int BOARD_SIZE = 3; //screaming case
    @Test
    public void testCreateGame() {

        /*Board board = new Board(BOARD_SIZE); //magic numbers == hard coded
        Player humanplayer = new HumanPlayer(GameSymbol.O, new User());
        Player bothplayer = new BotPlayer(GameSymbol.X, GameLevel.MEDIUM, new RandomPlayingStrategy());
        Game game = new Game(board, List.of(humanplayer, bothplayer),GameStatus.IN_PROGRESS);
*/

//        instead of the above code we can use builder pattern

        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(
                        new HumanPlayer(GameSymbol.O, new User())
                )
                .withPlayer(
                        new BotPlayer(GameSymbol.X, GameLevel.MEDIUM,new RandomPlayingStrategy())
                )
                .build();
        assertEquals(2, game.getPlayers().size(), "If Game is created , it should have 2 players");
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
