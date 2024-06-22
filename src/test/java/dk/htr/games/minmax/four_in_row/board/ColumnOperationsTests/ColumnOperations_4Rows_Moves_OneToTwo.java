package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BinaryStringHelper.columnStateToBinaryString;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_OneToTwo {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_OneToTwo.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   O
     * 1  O                O
     *
     * Before:   0111_1110
     * Expected: 0111_1100
     */
    @Test
    public void move_O_to_OO() throws GameException {
        int expected = COLUMN_OO;
        int result   = columnOperations.redMove(COLUMN_O);
        if(expected != result) {
            String gotStr =columnStateToBinaryString(result);
            logger.error("Before: 0111_1110 -> Red (0) -> Expected result: 01111100  <-- Got: " + gotStr);
        }
        assertEquals(expected, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   X
     * 1  O                O
     *
     * Before:   0111_1110
     * Expected: 0000_0010
     */
    @Test
    public void move_O_to_XO() throws GameException {
        int expected = COLUMN_XO;
        int result   = columnOperations.blueMove(COLUMN_O);
        assertEquals(COLUMN_XO, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   O
     * 1  X                X
     *
     * Before:   0000_000X
     * Expected: 0111_1101
     */
    @Test
    public void move_X_to_OX() throws GameException {
        int result   = columnOperations.redMove(COLUMN_X);
        assertEquals(COLUMN_OX, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   X
     * 1  X                X
     *
     * Before:   0000_0001
     * Expected: 0000_0011
     */
    @Test
    public void move_X_to_XX() throws GameException {
        int result   = columnOperations.blueMove(COLUMN_X);
        assertEquals(COLUMN_XX, result);
    }
}
