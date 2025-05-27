package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(int size) {
        //Arrays.fill();

        //List<String> name = Collections.nCopies(5,"tantia")

        //create the first row
/*        List<BoardCell> firstRow = Collections.nCopies(size, new BoardCell());
        //List<List<BoardCell>> rows = Collections.nCopies(size, firstRow);

        return Collections.nCopies(size, firstRow);*/

        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0,size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0,size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int col) {
       return cells.get(row).get(col).getSymbol() == null;
    }

    public void update(BoardCell move) {
        int row = move.getRow();
        int col = move.getCol();
        BoardCell cell = cells.get(row).get(col);
        cell.setSymbol(move.getSymbol());
    }
    public void printBoard() {
        for(int i = 0; i < cells.size(); ++i) {
            for(int j = 0; j < cells.size(); ++j ) {
                GameSymbol symbol = cells.get(i).get(j).getSymbol();

                if(symbol == null){
                    System.out.print(" | - | ");
                }
                else{
                    System.out.print(" | " + symbol + " | ");
                }
            }
            System.out.println();
        }
    }

    public List<BoardCell> getEmptyCells() {

        // itereate over the cells
        // Flattem teh array== 2d=>1D
        //filter out cells where symbol != null


        // Get a list of streams and combine it to one
        return cells.stream().flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();
    }
}
