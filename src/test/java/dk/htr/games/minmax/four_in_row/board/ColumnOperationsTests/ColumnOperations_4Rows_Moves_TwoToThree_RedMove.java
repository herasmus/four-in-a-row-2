package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.COLUMN_X;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_TwoToThree_RedMove {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_TwoToThree_RedMove.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

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
    public void move_OO_to_OOO() {
        int result   = columnOperations.redMove(COLUMN_OO);
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
        int result   = columnOperations.redMove(COLUMN_XO);
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
        int result   = columnOperations.redMove(COLUMN_OX);
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
        int result   = columnOperations.redMove(COLUMN_XX);
        assertEquals(COLUMN_OXX, result);
    }
}
