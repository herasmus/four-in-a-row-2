package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.COLUMN_OXX;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_TwoToThree_BlueMove {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_TwoToThree_BlueMove.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

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
    public void move_OO_to_XOO() {
        int result   = columnOperations.blueMove(COLUMN_OO);
        assertEquals(COLUMN_XOO, result);
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
    public void move_OO_to_XXO() {
        int result   = columnOperations.blueMove(COLUMN_XO);
        assertEquals(COLUMN_XXO, result);
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
    public void move_OX_to_XOX() {
        int result   = columnOperations.blueMove(COLUMN_OX);
        assertEquals(COLUMN_XOX, result);
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
    public void move_XX_to_XXX() {
        int result   = columnOperations.blueMove(COLUMN_XX);
        assertEquals(COLUMN_XXX, result);
    }
}
