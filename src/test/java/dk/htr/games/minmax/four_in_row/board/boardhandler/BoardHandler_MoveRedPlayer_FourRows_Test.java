package dk.htr.games.minmax.four_in_row.board.boardhandler;

import dk.htr.games.minmax.four_in_row.board.BoardHandler;
import dk.htr.games.minmax.four_in_row.board.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import static dk.htr.games.minmax.four_in_row.board.BinaryStringHelper.columnStateToBinaryString;
import static dk.htr.games.minmax.four_in_row.board.boardhandler.BoardConstants.EMPTY_COLUMN;
import static org.junit.jupiter.api.Assertions.*;

public class BoardHandler_MoveRedPlayer_FourRows_Test {
    private final Logger logger = LoggerFactory.getLogger(BoardHandler.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);
    BoardHandler boardHandler = new BoardHandler(gameDimensions, columnOperations);

    final static int state_O    = "";
    final static int state_O    = "";

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
    public void emptyColumn_1000_0000() throws GameException {
        int expected = 0b0111_1110;
        int result   = boardHandler.moveColumn(EMPTY_COLUMN, false);
        assertEquals(expected, result);
    }

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
    public void redMoveFrom_0111_1110_to_0111_1100() throws GameException {
        int expected = 0b01111100;
        int result   = boardHandler.moveColumn(0b0111_1110, false);
        if(expected != result) {
            String gotStr =columnStateToBinaryString(result);
            logger.error("Before: 0111_1110 -> Red (0) -> Expected result: 01111110  <-- Got: " + gotStr);
        }
        assertEquals(expected, result);
    }

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
    @Test
    public void redMoveFrom_0000_0001_to_0111_1101() throws GameException {
        int expected = 0b01111101;
        int result   = boardHandler.moveColumn(0b0000_0001, false);
        if(expected != result) {
            String gotStr =columnStateToBinaryString(result);
            logger.error("Before: 0111_1110 -> Red (0) -> Expected result: 01111110  <-- Got: " + gotStr);
        }
        assertEquals(expected, result);
    }

    @Test
    public void c_() throws GameException {
        int expected = 0b01111110;
        int result   = boardHandler.moveColumn(0b10000000, false);
        assertEquals(expected, result);
    }




    @Test
    public void roomFourOne() throws GameException {
        int expected = 0b11000010;
        int result = boardHandler.moveColumn(0b01111010, false);

        assertEquals(expected, result);
    }
}
