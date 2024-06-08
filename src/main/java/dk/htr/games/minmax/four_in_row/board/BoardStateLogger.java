package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BoardState.*;

public class BoardStateLogger {
    static final Logger logger = LoggerFactory.getLogger(BoardStateLogger.class);

    public static void logBoardStateTrace(long board,
                                          GameDimensions dimensions,
                                          int move) throws GameException {
        String[] boardStateStrings = getBoardStateStrings(board, dimensions, move);

        if(logger.isTraceEnabled()) {
            for(String str : boardStateStrings) {
                logger.trace(str);;
            }
        }
    }

    public static void logBoardStateWarn(long board,
                                         GameDimensions dimensions,
                                         int move) throws GameException {
        String[] boardStateStrings = getBoardStateStrings(board, dimensions, move);

        for(String str : boardStateStrings) {
            logger.warn(str);;
        }
    }
}
