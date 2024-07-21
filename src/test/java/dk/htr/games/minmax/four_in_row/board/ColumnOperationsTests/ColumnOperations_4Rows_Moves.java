package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.*;
import static dk.htr.games.minmax.four_in_row.board.BoardStateConstants.COLUMN_O;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);



    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   O
     * 1  X                X
     *
     * Before:   0111_1110
     * Expected: 0111_1100
     */
 /*   @Test
    public void redMoveFrom_0000_0001_to_0111_1101() throws GameException {
        int expected = 0b01111101;
        int result   = columnOperations.redMove4RowColumn(0b0000_0001);
        if(expected != result) {
            String gotStr =columnStateToBinaryString(result);
            logger.error("Before: 0111_1110 -> Red (0) -> Expected result: 01111110  <-- Got: " + gotStr);
        }
        assertEquals(expected, result);
    }*/
}
