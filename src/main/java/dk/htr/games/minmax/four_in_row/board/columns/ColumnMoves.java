package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public interface ColumnMoves {
    int makeMoveBlue(int presentState) throws BoardStateException;
    int makeMoveRed(int presentState) throws BoardStateException;
}
