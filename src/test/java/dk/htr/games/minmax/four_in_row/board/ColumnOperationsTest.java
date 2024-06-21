package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.ColumnOperations.isEmpty;
import static dk.htr.games.minmax.four_in_row.board.ColumnOperations.isFull;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperationsTest {
    @Test
    public void isColumnEmpty() {
        assertTrue(isEmpty(0b10000000));
        assertFalse(isEmpty(0b01001101));
    }

    /*
    @Test
    public void isEmptyColumnValid() {
        assertTrue(validEmptyColumn(0b10000000));
        for(int i = 1; i < 0b111111; i++) {
            int testValue = 0b10000000 | i;
            assertFalse(validEmptyColumn(testValue));
        }
    }

    @Test
    public void isFullColumnValid() {
        assertTrue(validFullColumn(0b10000000));
        fail();
    }

    @Test
    public void isPartlyColumnValid() {
        fail();
    } */

    @Test
    public void isColumnFull() {
        assertTrue(isFull(0b11000000));
        assertFalse(isFull(0b01001101));
    }

    @Test
    public void getNumberOfCounters_7x6() throws GameException {
        GameDimensions gameDimensions = new GameDimensions(7, 6, 4);
        ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

        assertEquals(0, columnOperations.getNumberOfCounters(0b10000000));
        assertEquals(1, columnOperations.getNumberOfCounters(0b00000001));
        assertEquals(2, columnOperations.getNumberOfCounters(0b00000010));
        assertEquals(3, columnOperations.getNumberOfCounters(0b00000110));
        assertEquals(4, columnOperations.getNumberOfCounters(0b01110010));
        assertEquals(5, columnOperations.getNumberOfCounters(0b01101010));
        assertEquals(6, columnOperations.getNumberOfCounters(0b11101101));
    }
}
