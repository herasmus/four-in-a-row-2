package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

public interface MoveExecuter {
    long moveBlue(long presentBoard, int move) throws GameException;
    long moveRed(long presentBoard, int move) throws GameException;
}
