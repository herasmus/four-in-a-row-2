package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.*;
import static dk.htr.games.minmax.four_in_row.board.ColumnOperations.*;

public class BoardHandler {
    private static GameDimensions dimensions;
    public static void setGameSettings(GameDimensions dim) {
        dimensions = dim;
    }

    protected static int moveBluePlayer(int column) {
        if(isEmpty(column)) {
            column = 0b00000001;
        } else {

            return -1;
        }
        return column;
    }

    protected static int moveRedPlayer(int column) throws GameException {
        int nrOfCounters = getNumberOfCounters(dimensions, column);

        if(nrOfCounters == 0) {
            return 0b01111110;
        } else if (nrOfCounters == dimensions.nrOfRows() - 1) {
            // Full mask | with (current first bit and new 6th bit (which is 0))
            return 0b11000000 | (column & 0b00011111);
        } else {
            int mask = getNTimesOneRightMask(nrOfCounters - 1);
            column = column & mask;
            // No need to turn bit nrOfCounters off - the mask takes care of that
            // Set the filler bits - for red they are always 1
            for(int i = (nrOfCounters + 1); i < 7; i++) {
                column = turnOn(column, i);
            }
            return column;
        }
    }

    public static long move(long board, int move, boolean bluePlayer) throws GameException {
        int column = readByte(board, move);
        if(bluePlayer) {
            column = moveBluePlayer(column);
        } else {
            column = moveRedPlayer(column);
        }
        board = writeByte(board, column, move);
        return board;
    }

    /**
     * Return available slots as a bitpattern:
     *
     * Example: Slot 1 and 4 is free will yield:
     *
     * 0b00001001
     *
     * @param board
     * @return
     */
    public static byte getAvailableSlots(long board) {
        byte res = 0;
        byte shiftBit = 1;
        for(int columnNumber = 1; columnNumber <= dimensions.nrOfColumns(); columnNumber++) {
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
