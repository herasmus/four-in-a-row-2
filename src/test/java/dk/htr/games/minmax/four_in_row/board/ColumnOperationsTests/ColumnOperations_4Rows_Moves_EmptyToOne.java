package dk.htr.games.minmax.four_in_row.board.ColumnOperationsTests;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColumnOperations_4Rows_Moves_EmptyToOne {
    private final Logger logger = LoggerFactory.getLogger(ColumnOperations_4Rows_Moves_EmptyToOne.class);
    GameDimensions gameDimensions = new GameDimensions(6, 4, 3);
    ColumnOperations columnOperations = new ColumnOperations(gameDimensions);

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
    public void move_EMPTY_to_O() throws GameException {
        assertEquals(COLUMN_O, columnOperations.redMove(COLUMN_EMPTY));
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2
     * 1                   X
     *
     * Before:   1000_0000
     * Expected: 0000_0001
     */
    @Test
    public void move_EMPTY_to_X() throws GameException {
        assertEquals(COLUMN_X, columnOperations.blueMove(COLUMN_EMPTY));
    }
}
