package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<BoardCell> firstRow = Collections.nCopies(size, new BoardCell());
        //List<List<BoardCell>> rows = Collections.nCopies(size, firstRow);

        return Collections.nCopies(size, firstRow);
    }
}
