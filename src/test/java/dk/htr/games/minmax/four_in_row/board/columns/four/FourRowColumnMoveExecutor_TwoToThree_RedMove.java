package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_TwoToThree_RedMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

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
        int result   = columnMoves.moveRed(COLUMN_OO.getValue());
        assertEquals(COLUMN_OOO.getValue(), result);
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
        int result   = columnMoves.moveRed(COLUMN_XO.getValue());
        assertEquals(COLUMN_OXO.getValue(), result);
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
        int result   = columnMoves.moveRed(COLUMN_OX.getValue());
        assertEquals(COLUMN_OOX.getValue(), result);
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
        int result   = columnMoves.moveRed(COLUMN_XX.getValue());
        assertEquals(COLUMN_OXX.getValue(), result);
    }
}
