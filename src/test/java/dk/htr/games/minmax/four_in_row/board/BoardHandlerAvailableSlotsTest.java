package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardHandlerAvailableSlotsTest {

    @Test
    public void noAvailableSlots() throws GameException {
        var dim = new GameDimensions(2, 4, 3);
        BoardHandler.setGameSettings(dim);
        final long board = 0b11000011_11001101L;
        byte res = BoardHandler.getAvailableSlots(board);
        byte expected = 0b00000000;
        if(res != expected) {
            BoardStateLogger.logBoardStateWarn(board, dim, 2);
        }
        assertEquals(expected, res);
    }

    /*
     *  5 x 4 board
     * -------------
     *
     *                           x
     *                           x                               o
     *                           o                               x
     *                           x               o       x       o
     *                  ---------------------------------------------------
     *                   Column: 1       2       3       4       5
     */
    @Test
    public void someAvailableSlots() throws GameException {
        var dim = new GameDimensions(5, 4, 3);
        BoardHandler.setGameSettings(dim);
        final long board = 0b00111010_00000001_00111110_10000000_11001101L;
        byte got = BoardHandler.getAvailableSlots(board);
        byte expected = 0b00011110;
        if(got != expected) {
            BoardStateLogger.logBoardStateWarn(board, dim, 2);
        }
        assertEquals(expected, got);
    }

    @Test
    public void maxAvailableSlots() throws GameException {
        var dim = new GameDimensions(5, 4, 3);
        BoardHandler.setGameSettings(dim);
        final long board = 0b01111010_00000001_00000010_01111110_00000101L;
        byte res = BoardHandler.getAvailableSlots(board);
        byte expected = 0b00011111;
        if(res != expected) {
            BoardStateLogger.logBoardStateWarn(board, dim, 2);
        }
        assertEquals(expected, res);
    }
}
