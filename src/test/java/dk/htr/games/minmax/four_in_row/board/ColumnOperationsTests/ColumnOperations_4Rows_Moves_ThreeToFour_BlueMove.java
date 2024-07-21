package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.COLUMN_XXX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_ThreeToFour_BlueMove {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_ThreeToFour_BlueMove.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1000
     * Expected: 1100_1000
     */
    @Test
    public void move_OOO_to_XOOO() {
        int result   = columnOperations.blueMove(COLUMN_OOO);
        assertEquals(COLUMN_4R_XOOO, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1001
     * Expected: 1100_1001
     */
    @Test
    public void move_OOX_to_XOOX() {
        int result   = columnOperations.blueMove(COLUMN_OOX);
        assertEquals(COLUMN_4R_XOOX, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0111_1010
     * Expected: 1100_1010
     */
    @Test
    public void move_OXO_to_XOXO() {
        int result   = columnOperations.blueMove(COLUMN_OXO);
        assertEquals(COLUMN_4R_XOXO, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0111_1011
     * Expected: 1100_1011
     */
    @Test
    public void move_OXX_to_XOXX() {
        int result   = columnOperations.blueMove(COLUMN_OXX);
        assertEquals(COLUMN_4R_XOXX, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0000_0100
     * Expected: 1100_1100
     */
    @Test
    public void move_XOO_to_XXOO() {
        int result   = columnOperations.blueMove(COLUMN_XOO);
        assertEquals(COLUMN_4R_XXOO, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_0101
     * Expected: 1100_1101
     */
    @Test
    public void move_XOX_to_XXOX() {
        int result   = columnOperations.blueMove(COLUMN_XOX);
        assertEquals(COLUMN_4R_XXOX, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0110
     * Expected: 1100_1110
     */
    @Test
    public void move_XXO_to_XXXO() {
        int result   = columnOperations.blueMove(COLUMN_XXO);
        assertEquals(COLUMN_4R_XXXO, result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_01110
     * Expected: 1100_1111
     */
    @Test
    public void move_XXX_to_XXXX() {
        assertEquals(COLUMN_4R_XXXX, columnOperations.blueMove(COLUMN_XXX));
    }
}
