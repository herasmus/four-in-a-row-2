package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;

public interface WinDetector {
    WinResult hasWinner(long board, int move, boolean blueDisc) throws GameException;
}
