package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.apache.commons.lang3.NotImplementedException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.readByte;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.COLUMN_4R_OOOO;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.COLUMN_4R_XXXX;

public class VerticalWinDetector implements WinDetector {
    private final GameDimensions gameDimensions;

    public VerticalWinDetector(GameDimensions gameDimensions) throws GameException {
        this.gameDimensions = gameDimensions;
    }

    private WinResult getFourRowFourDiscWinner(long board, int move, boolean blueDisc) {
        throw new NotImplementedException("FourRowThreeDiscWinner detection now implemented");
    }

    private WinResult getFourRowThreeDiscWinner(long board, int move, boolean blueDisc) {
        throw new NotImplementedException("FourRowThreeDiscWinner detection now implemented");
    }

    private WinResult getFourRowWinner(long board, int move, boolean blueDisc) throws GameException {
        if(gameDimensions.getLengthToWin() == 4) {
            return getFourRowFourDiscWinner(board, move, blueDisc);
        } else if(gameDimensions.getLengthToWin() == 3) {
            return getFourRowThreeDiscWinner(board, move, blueDisc);
        } else {
            throw new GameException("Only support 3 and 4 discs in a row to win at the moment");
        }
    }

    public WinResult getWinResult(long board, int move, boolean blueDisc) throws GameException {
        boolean result = false;
        if(gameDimensions.getNrOfRows() == 4) {
            return getFourRowWinner(board, move, blueDisc);
        } else {
            throw new GameException("Only support 4-rows at the moment");
        }
    }
}
