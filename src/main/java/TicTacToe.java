import exceptions.InvalidSymbolException;
import models.*;
import strategies.RandomPlayingStrategy;

import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    public static void main(String[] args) {
        //ask user input - name, email, symbol
        System.out.println("Welcome to Tic-Tac-Toe!");

        HumanPlayer human = getUserInput();
        System.out.println("Human player Created " +human.getSymbol());

        //create a game
        Game game = createGame(human);
        game.start();


        //initialize the bot player
        // H vs B





        //start game
        //assign the first player
        //mark the game in progress

        // Iteratively call makeMove
        // unitl -> game is won or drawn

        while(game.getStatus() == GameStatus.IN_PROGRESS){
            Player player = game.getNextPlayer();
            System.out.println("Next Player: " + player.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();
        }




        //start playing
        //

        if(game.getStatus() == GameStatus.FINISHED){
            System.out.println("Winner is " + game.getWinner().getSymbol());

        }
    }

    private static Game createGame(HumanPlayer humanPlayer) {
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(new BotPlayer(decideBotSymbol(humanPlayer.getSymbol()), GameLevel.MEDIUM,new RandomPlayingStrategy()))
                .build();
    }

    private static GameSymbol decideBotSymbol(GameSymbol symbol) {
        if(symbol == GameSymbol.O) {
            return GameSymbol.X;
        }

        return GameSymbol.O;
    }

    public static HumanPlayer getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your Email: ");
        String email = sc.nextLine();

        System.out.println("Enter your Symbol (O or X): ");
        GameSymbol symbol;
        try {
            symbol = GameSymbol.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            throw  new InvalidSymbolException();
        }

        User user = new User(name, email, null);

        return  HumanPlayer.builder()
                .symbol(symbol)
                .user(user).build();

    }
}
