package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FourRowColumnMoveTest {
    FourRowColumnMove fourRowColumnMove = new FourRowColumnMove();

    @Test
    public void outOfBoundsLessThanZero() {
        fourRowColumnMove.makeMoveBlue()


        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            validator.isValidColumn(-1);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Column state cant be less than 0x00", thrown.getMessage());
    }
}
