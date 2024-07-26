package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import static dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_EmptyToOne {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4
     * 3
     * 2
     * 1                   O
     *
     * Before:   1000_0000
     * Expected: 0111_1110
     */
    @Test
    public void move_EMPTY_to_O() throws GameException {
        assertEquals(COLUMN_O, columnMoves.moveRed(COLUMN_EMPTY));
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2
     * 1                   X
     *
     * Before:   1000_0000
     * Expected: 0000_0001
     */
    @Test
    public void move_EMPTY_to_X() throws GameException {
        assertEquals(COLUMN_X, columnMoves.moveBlue(COLUMN_EMPTY));
    }
}
