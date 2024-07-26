package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_TwoToThree_BlueMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();
    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1100
     * Expected: 0000_0100
     */
    @Test
    public void move_OO_to_XOO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OO.getValue());
        assertEquals(COLUMN_XOO.getValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0010
     * Expected: 0000_0110
     */
    @Test
    public void move_OO_to_XXO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_XO.getValue());
        assertEquals(COLUMN_XXO.getValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1101
     * Expected: 0000_0101
     */
    @Test
    public void move_OX_to_XOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OX.getValue());
        assertEquals(COLUMN_XOX.getValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0011
     * Expected: 0000_0111
     */
    @Test
    public void move_XX_to_XXX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_XX.getValue());
        assertEquals(COLUMN_XXX.getValue(), result);
    }
}
