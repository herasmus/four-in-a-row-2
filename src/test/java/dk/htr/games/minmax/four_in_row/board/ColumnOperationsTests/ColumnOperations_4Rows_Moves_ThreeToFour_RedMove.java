package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.COLUMN_4R_XXXX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_ThreeToFour_RedMove {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_ThreeToFour_RedMove.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

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
    public void move_OOO_to_OOOO() {
        assertEquals(COLUMN_4R_OOOO, columnOperations.redMove(COLUMN_OOO));
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
    public void move_OOX_to_OOOX() {
        int result   = columnOperations.redMove(COLUMN_OOX);
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
    public void move_OXO_to_OOXO() {
        int result   = columnOperations.redMove(COLUMN_OXO);
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
    public void move_OXX_to_OOXX() {
        int result   = columnOperations.redMove(COLUMN_OXX);
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
    public void move_XOO_to_OXOO() {
        int result   = columnOperations.redMove(COLUMN_XOO);
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
    public void move_XOX_to_OXOX() {
        int result   = columnOperations.redMove(COLUMN_XOX);
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
    public void move_XXO_to_OXXO() {
        assertEquals(COLUMN_4R_OXXO, columnOperations.redMove(COLUMN_XXO));
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
    public void move_XXX_to_OXXX() {
        assertEquals(COLUMN_4R_OXXX, columnOperations.redMove(COLUMN_XXX));
    }
}
