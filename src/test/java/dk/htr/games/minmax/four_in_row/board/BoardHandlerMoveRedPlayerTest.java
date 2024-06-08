package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static dk.htr.games.minmax.four_in_row.board.BoardHandler.moveRedPlayer;

public class BoardHandlerMoveRedPlayerTest {
    @Test
    public void emptyColumn_7x6() throws GameException {
        BoardHandler.setGameSettings(new GameDimensions(7, 6, 3));
        int expected = expected = 0b01111110;
        int result   = moveRedPlayer(0b10000000);
        assertEquals(expected, result);
    }

    @Test
    public void emptyColumn_6x4() throws GameException {
        BoardHandler.setGameSettings(new GameDimensions(6, 4, 3));
        int expected = expected = 0b01111110;
        int result   = moveRedPlayer(0b10000000);
        assertEquals(expected, result);
    }

    @Test
    public void roomFourOne_6x4() throws GameException {
        BoardHandler.setGameSettings(new GameDimensions(6, 4, 3));
        int expected = 0b11000010;
        int result   = moveRedPlayer(0b01111010);

        assertEquals(expected, result);
    }

    @Test
    public void roomFourOne_7x6() throws GameException {
        BoardHandler.setGameSettings(new GameDimensions(7, 6, 4));
        int expected = 0b11011010;
        int result   = moveRedPlayer(0b00011010);
        assertEquals(expected, result);

        // 2 x 4 x 3
        BoardHandler.setGameSettings(new GameDimensions(2, 4, 3));
        expected = 0b11000010;
        result   = moveRedPlayer(0b01111010);

        assertEquals(expected, result);
    }
}
