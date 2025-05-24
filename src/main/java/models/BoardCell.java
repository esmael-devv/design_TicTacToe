package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardCell {

        private int row;
        private int col;
        private GameSymbol symbol;

}
