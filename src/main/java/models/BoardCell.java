package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BoardCell {

        private int row;
        private int col;
        private GameSymbol symbol;
        public BoardCell(int row, int col) {
                this.row = row;
                this.col = col;
        }

}
