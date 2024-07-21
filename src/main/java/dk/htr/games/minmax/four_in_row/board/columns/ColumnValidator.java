package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public interface ColumnValidator {
    boolean isValidColumn(int column) throws BoardStateException;
}
