package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class BoardStateLogger {
    @Autowired
    private final BoardState boardState;

    static final Logger logger = LoggerFactory.getLogger(BoardStateLogger.class);

    public void logBoardStateTrace(long board, int move) throws GameException {
        String[] boardStateStrings = boardState.getBoardStateStrings(board, move);

        if(logger.isTraceEnabled()) {
            for(String str : boardStateStrings) {
                logger.trace(str);;
            }
        }
    }

    public void logBoardStateWarn(long board, int move) throws GameException {
        String[] boardStateStrings = boardState.getBoardStateStrings(board, move);

        for(String str : boardStateStrings) {
            logger.warn(str);;
        }
    }
}
