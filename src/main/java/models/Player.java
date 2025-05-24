package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Player {
      private GameSymbol symbol;

      public abstract BoardCell makeMove(Board board);

}
