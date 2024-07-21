package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoves_TwoToThree_RedMove {
    FourRowColumnMoves columnMoves = new FourRowColumnMoves();

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1100
     * Expected: 0111_1000
     */
    @Test
    public void move_OO_to_OOO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_OO);
        assertEquals(COLUMN_OOO, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0010
     * Expected: 0111_1010
     */
    @Test
    public void move_OO_to_OXO() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_XO);
        assertEquals(COLUMN_OXO, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_000X
     * Expected: 0111_1001
     */
    @Test
    public void move_OX_to_OOX() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_OX);
        assertEquals(COLUMN_OOX, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0001
     * Expected: 0000_0011
     */
    @Test
    public void move_XX_to_OXX() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_XX);
        assertEquals(COLUMN_OXX, result);
    }
}
