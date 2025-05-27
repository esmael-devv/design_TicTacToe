package models;

import exceptions.InvalidMoveException;
import exceptions.InvalidPlayersException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import strategies.RowWinningStrategy;
import strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter

public class Game{
    private static  final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;

    private  Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private  Player winner;
    private List<WinningStrategy>  winningStrategies = List.of(new RowWinningStrategy());



    public void start(){
        // Assign a random value to the nextPlayerIndex
        // randome value -> 0 or 1
        // 0.5 * 2 = 1.0 = 1
        // 0.1 * 2 = 0.2 = 0
        // 0.8 * 2 = 1.6 = 1
        nextPlayerIndex = (int) (Math.random() * players.size());

        //set the status to IN_PROGRESS
        status = DEFAULT_STATUS;

    }

    public void makeMove(){
        //get the next move
        BoardCell move = getNextMove();
        // Validate the move - check if the cell was already filled
//        validateMove(move);
//        we can even validate this move in our nextMove method
        //makeMove
        //Bot - PlayingStrategy
        //User - input = Scanner

        // Update the board
        board.update(move);

        //check for a winner
        if(checkWinner(move.getSymbol())){
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }

        //check for a draw
        if(checkDraw()){
           status = GameStatus.DRAWN;
           return;
        }

       nextPlayerIndex = (nextPlayerIndex + 1) % PLAYER_COUNT;
    }

    private void validateMove(BoardCell move) {
        if(!board.isEmpty(move.getRow(), move.getCol())){
            throw new InvalidMoveException(move.getRow(), move.getCol());
        }


    }

    private BoardCell getNextMove() {
        Player player = players.get(nextPlayerIndex);
        //get the next move from the player
        BoardCell move = player.makeMove(board);
        validateMove(move);
        return move;
    }

    private boolean checkWinner(GameSymbol symbol){
        // Implement check rows
        for(WinningStrategy strategy : winningStrategies){
            boolean hasWinner = strategy.checkWinner(getBoard(), symbol);
            if(hasWinner){
                return true;
            }
        }
        return false;
        // check cols and diagonal
    }



    private boolean checkDraw(){
        return false;
    }
    private Game(){}

    public static Builder builder(){
        return new Builder();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public static class Builder{
        private Game game;

        private Builder(){
            game = new Game();
        }
        public Builder withSize(int size){
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player){
            game.players.add(player);
            return this;
        }

        public Game build(){
            boolean isvalid = validate();
            if(!isvalid){
                throw new InvalidPlayersException();
            }
            Game newgame = new Game();
            newgame.board = game.board;
            newgame.players = game.players;
            newgame.status = DEFAULT_STATUS;
            return newgame;
        }

        private boolean validate(){
//          creating a lsit so that you donot need to access the players through
//          game.players everytime small optimization
            List<Player> players = game.players;

            if(players.size() != PLAYER_COUNT){
                return false;
            }

            //if symbols are unique
            Set<GameSymbol> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

            /*if(symbols.size() != PLAYER_COUNT){
                return false;
            }
            return true;*/
//          instead of above code simply return like below
            return symbols.size() == PLAYER_COUNT;
        }
    }

}
