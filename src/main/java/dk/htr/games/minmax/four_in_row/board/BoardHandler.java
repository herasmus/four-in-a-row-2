package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.*;
import static dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations.isEmpty;
import static dk.htr.games.minmax.four_in_row.board.columns.ColumnOperations.isFull;

@Setter
@Getter
@RequiredArgsConstructor
@Component
public class BoardHandler {
    private final GameDimensions dimensions;
    private final ColumnOperations columnOperations;

    protected static int moveBluePlayer(int column) {
        if(isEmpty(column)) {
            column = 0b00000001;
        } else {

            return -1;
        }
        return column;
    }

    private int moveRedPlayer(int columnState) throws GameException {
        int nrOfCounters = columnOperations.getNumberOfCounters(columnState);

        if(nrOfCounters == 0) {
            return 0b01111110;
        } else if (nrOfCounters == dimensions.getNrOfRows() - 1) {


            // Full mask | with (current first bit and new 6th bit (which is 0))
            return 0b11000000 | (columnState & 0b00001111);
        } else {
            int mask = getNTimesOneRightMask(nrOfCounters - 1);
            columnState = columnState & mask;
            // No need to turn bit nrOfCounters off - the mask takes care of that
            // Set the filler bits - for red they are always 1
            for(int i = (nrOfCounters + 1); i < 7; i++) {
                columnState = turnOn(columnState, i);
            }
            return columnState;
        }
    }

    public int moveColumn(int columnState, boolean isBluePlayer) throws GameException {
        int newColumnState;
        if(!ColumnValidatorOld.isValidColumnState(columnState, dimensions.getNrOfRows())) {
            throw new BoardStateException("Invalid Column state: " + columnState);
        }
        if(isBluePlayer) {
            newColumnState = moveBluePlayer(columnState);
        } else {
            newColumnState = moveRedPlayer(columnState);
        }
        return newColumnState;
    }

    public long move(long board, int move, boolean isBluePlayer) throws GameException {
        int columnState = moveColumn(readByte(board, move), isBluePlayer);
        return writeByte(board, columnState, move);
    }

    /**
     * Return available slots as a bit-pattern:
     *
     * Example: Slot 1 and 4 is free will yield:
     *
     * 0b00001001
     *
     * @param board
     * @return
     */
    public byte getAvailableSlots(long board) {
        byte res = 0;
        byte shiftBit = 1;
        for(int columnNumber = 1; columnNumber <= dimensions.getNrOfColumns(); columnNumber++) {
            int column = (int)board & 0b11111111;
            if(!isFull(column)) {
                res |= shiftBit;
            }
            shiftBit <<= 1;
            board >>= 8;
        }
        return res;
    }

    public int getMoveResult(long board) {



        return -1;
    }
}
