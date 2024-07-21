package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.getBit;

public class ColumnUtility {
    // Bit 7 and 6 used for marking empty and full
    //
    // 10xxxxxx == EMPTY
    // 11xxxxxx == FULL

    public static int COLUMN_EMPTY_PATTERN   = 0b1000_0000;
    public static int COLUMN_FULL_PATTERN    = 0b1100_0000;
    public static int COLUMN_EMPTY_FULL_MASK = 0b1100_0000;

    public static boolean isEmpty(int column) {
        return (column & COLUMN_EMPTY_FULL_MASK) == COLUMN_EMPTY_PATTERN;
    }

    public static boolean isFull(int column) {
        return (column & COLUMN_EMPTY_FULL_MASK) == COLUMN_FULL_PATTERN;
    }

    private final GameDimensions dimensions;

    public ColumnUtility(GameDimensions dimensions) {
        this.dimensions = dimensions;
    }

    public int getNumberOfCounters(int column) throws GameException {
        if(isEmpty(column)) return 0;
        if(isFull(column))  return dimensions.getNrOfRows();
        int bitNumber = 7;
        int fillerBitValue = getBit(column, bitNumber);
        int bitValue;
        do {
            bitNumber--;
            bitValue = getBit(column, bitNumber);
        } while(fillerBitValue == bitValue);
        if(bitNumber < 1) throw new GameException("Didn't find any non filler-bits");
        return bitNumber;
    }
}
