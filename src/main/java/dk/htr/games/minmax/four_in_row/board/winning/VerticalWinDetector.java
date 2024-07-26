package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.readByte;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.COLUMN_4R_OOOO;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.COLUMN_4R_XXXX;

public class VerticalWinDetector implements WinDetector {
    private final GameDimensions gameDimensions;

    public VerticalWinDetector(GameDimensions gameDimensions) {
        this.gameDimensions = gameDimensions;
    }

    public WinResult hasWinner(long board, int move, boolean blueDisc) throws GameException {
        boolean result = false;
        if(gameDimensions.getLengthToWin() != 4) {
            throw new GameException("Only support 4-in-row-to-win at the moment");
        }
        if(gameDimensions.getNrOfRows() != 4) {
            throw new GameException("Only support 4-rows at the moment");
        }
        int column = readByte(board, move-1);
        if(blueDisc) {
            result = (column == COLUMN_4R_XXXX.getValue());
        } else {
            result = (column == COLUMN_4R_OOOO.getValue());
        }
        return new WinResult(result);
    }
}
