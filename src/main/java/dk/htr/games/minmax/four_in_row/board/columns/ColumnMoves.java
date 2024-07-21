package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public interface ColumnMoves {
    int moveBlue(int presentState) throws BoardStateException;
    int moveRed(int presentState) throws BoardStateException;
}
