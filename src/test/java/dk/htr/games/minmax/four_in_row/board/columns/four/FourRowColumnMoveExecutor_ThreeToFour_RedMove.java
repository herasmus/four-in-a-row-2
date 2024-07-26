package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_ThreeToFour_RedMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1000
     * Expected: 1100_0000
     */
    @Test
    public void move_OOO_to_OOOO() throws BoardStateException {
        assertEquals(COLUMN_4R_OOOO, columnMoves.moveRed(COLUMN_OOO));
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1001
     * Expected: 1100_0001
     */
    @Test
    public void move_OOX_to_OOOX() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_OOX);
        assertEquals(COLUMN_4R_OOOX, result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0111_1010
     * Expected: 1100_0010
     */
    @Test
    public void move_OXO_to_OOXO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_OXO);
        assertEquals(COLUMN_4R_OOXO, result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0111_1011
     * Expected: 1100_0011
     */
    @Test
    public void move_OXX_to_OOXX() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_OXX);
        assertEquals(COLUMN_4R_OOXX, result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0000_0100
     * Expected: 1100_0100
     */
    @Test
    public void move_XOO_to_OXOO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_XOO);
        assertEquals(COLUMN_4R_OXOO, result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_0101
     * Expected: 1100_0101
     */
    @Test
    public void move_XOX_to_OXOX() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_XOX);
        assertEquals(COLUMN_4R_OXOX, result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0110
     * Expected: 1100_0110
     */
    @Test
    public void move_XXO_to_OXXO() throws BoardStateException {
        assertEquals(COLUMN_4R_OXXO, columnMoves.moveRed(COLUMN_XXO));
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0111
     * Expected: 1100_0111
     */
    @Test
    public void move_XXX_to_OXXX() throws BoardStateException {
        assertEquals(COLUMN_4R_OXXX, columnMoves.moveRed(COLUMN_XXX));
    }
}