package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.getBit;

public class ColumnOperations {
    private final static String underflowExcStr = "Underflow: Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";
    private final static String overflowExcStr  = "Overflow:  Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";

    // Bit 7 and 6 used for marking empty and full
    //
    // 10xxxxxx == EMPTY
    // 11xxxxxx == FULL

    public static int COLUMN_EMPTY_PATTERN   = 0b1000_0000;
    public static int COLUMN_FULL_PATTERN    = 0b1100_0000;
    public static int COLUMN_EMPTY_FULL_MASK = 0b1100_0000;

    protected static boolean isEmpty(int column) {
        return (column & COLUMN_EMPTY_FULL_MASK) == COLUMN_EMPTY_PATTERN;
    }

    protected static boolean isFull(int column) {
        return (column & COLUMN_EMPTY_FULL_MASK) == COLUMN_FULL_PATTERN;
    }

    private static void validateIndex(int column, int strArrayLength, int bitNumber, int index) throws GameException {
        String columnBinaryString =Integer.toBinaryString(column);
        if(index < 0) {
            String exceptionString = String.format(underflowExcStr, columnBinaryString, strArrayLength, bitNumber, index);
            throw new GameException(exceptionString);
        } else if((index + 1) > strArrayLength) {
            String exceptionString = String.format(overflowExcStr, columnBinaryString, strArrayLength, bitNumber, index);
            throw new GameException(exceptionString);
        }
    }

    private static boolean hasEmptyPattern(int column) {
        return (column & COLUMN_EMPTY_FULL_MASK) == COLUMN_EMPTY_PATTERN;
    }
    protected static boolean validEmptyColumn(int column) {
        if(hasEmptyPattern(column)) {
            int withoutPattern = column & 0b00111111;
            if(withoutPattern != 0) return false;
        }
        return true;
    }

    private static boolean isValidColumn(int column, int height) {
        if(isEmpty(column)) {
            return validEmptyColumn(column);
        } /*else if (fullColumn) {
            return false;
        } else {
            return false;
        }


        boolean valid = true;
        if(column == 0b0000_0000 || column == 0b0111_1111 ) {
            valid = false;
        } else if(!) {
            valid = false;
        }
        if(!valid) {
            String columnBinaryString =Integer.toBinaryString(column);
           // lkjn
        } */
        return false;
    }

    private static void addPartlyFilledColumn(int column,
                                              GameDimensions dimensions,
                                              String[] rowStrings) throws GameException {
        int bitNumber = 7;
        int fillerBitValue = getBit(column, bitNumber);
        int bitValue;
        do {
            if(bitNumber <= dimensions.nrOfRows()) {
                int index = dimensions.nrOfRows() - bitNumber;
                assert isValidColumn(column, dimensions.nrOfRows()) : "Invalid column";
                assert (index < 7 && index >= 0) : "Invalid index: " + index;
                rowStrings[index] += ". ";
            }
            bitNumber--;
            bitValue = getBit(column, bitNumber);
        } while(fillerBitValue == bitValue);
        // Real bits
        do {
            bitValue = getBit(column, bitNumber);
            char counterChar = bitValue == 1 ? 'x' : 'o';
            rowStrings[dimensions.nrOfRows() - bitNumber] += "" + counterChar + ' ';
            bitNumber--;
        } while(bitNumber > 0);
    }

    protected static int getNumberOfCounters(GameDimensions dimensions, int column) throws GameException {
        if(isEmpty(column)) return 0;
        if(isFull(column))  return dimensions.nrOfRows();
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

    private static void addEmptyColumn(GameDimensions dimensions, String[] rowStrings) {
        for (int rowNumber = 0; rowNumber < dimensions.nrOfRows(); rowNumber++) {
            rowStrings[rowNumber] += ". ";
        }
    }

    private static void addFullColumn(int column, GameDimensions dimensions, String[] rowStrings) {
        for (int rowNumber = 0; rowNumber < dimensions.nrOfRows(); rowNumber++) {
            int columnBit = getBit(column, dimensions.nrOfRows() - rowNumber);
            char valChar = columnBit == 1 ? 'x' : 'o';
            rowStrings[rowNumber] += "" + valChar + ' ';
        }
    }

    public static void addColumnStr(int column,
                                    GameDimensions dimensions,
                                    String[] rowStrings) throws GameException {
        if (isEmpty(column)) {
            addEmptyColumn(dimensions, rowStrings);
        } else if (isFull(column)) {
            addFullColumn(column, dimensions, rowStrings);
        } else {
            addPartlyFilledColumn(column, dimensions, rowStrings);
        }
    }
}
