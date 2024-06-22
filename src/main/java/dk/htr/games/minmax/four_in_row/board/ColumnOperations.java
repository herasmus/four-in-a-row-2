package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.getBit;
import static dk.htr.games.minmax.four_in_row.board.Moves.BLUE_MOVES_4R;
import static dk.htr.games.minmax.four_in_row.board.Moves.RED_MOVES_4R;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class ColumnOperations {
    @Autowired
    private final GameDimensions dimensions;

    private final static String underflowExcStr = "Underflow: Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";
    private final static String overflowExcStr  = "Overflow:  Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";

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

    private void addPartlyFilledColumn(int column, String[] rowStrings) throws GameException {
        int bitNumber = 7;
        int fillerBitValue = getBit(column, bitNumber);
        int bitValue;
        do {
            if(bitNumber <= dimensions.getNrOfRows()) {
                int index = dimensions.getNrOfRows() - bitNumber;
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
            rowStrings[dimensions.getNrOfRows() - bitNumber] += "" + counterChar + ' ';
            bitNumber--;
        } while(bitNumber > 0);
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

    private void addEmptyColumn(String[] rowStrings) {
        for (int rowNumber = 0; rowNumber < dimensions.getNrOfRows(); rowNumber++) {
            rowStrings[rowNumber] += ". ";
        }
    }

    private void addFullColumn(int column, String[] rowStrings) {
        for (int rowNumber = 0; rowNumber < dimensions.getNrOfRows(); rowNumber++) {
            int columnBit = getBit(column, dimensions.getNrOfRows() - rowNumber);
            char valChar = columnBit == 1 ? 'x' : 'o';
            rowStrings[rowNumber] += "" + valChar + ' ';
        }
    }

    public void addColumnStr(int columnState, String[] rowStrings) throws GameException {
        if(!ValidColumnStateChecker.isValidColumnState(columnState, dimensions.getNrOfRows())) throw new GameException("Invalid column");
        if (isEmpty(columnState)) {
            addEmptyColumn(rowStrings);
        } else if (isFull(columnState)) {
            addFullColumn(columnState, rowStrings);
        } else {
            addPartlyFilledColumn(columnState, rowStrings);
        }
    }

    public int redMove(int columnBefore) {
        int columnAfter;
        if(dimensions.getNrOfRows() == 4) {
            columnAfter = RED_MOVES_4R[columnBefore];
        } /*else if(dimensions.getNrOfRows() == 6) {
            columnAfter = RED_MOVES_6R[columnBefore];
        }*/
        else {
            throw new IllegalArgumentException();
        }
        assert ValidColumnStateChecker.isValid4RowColumnState(columnAfter) : "Not a valid column: " + columnAfter;
        return columnAfter;
    }

    public int blueMove(int columnBefore) {
        int columnAfter;
        if(dimensions.getNrOfRows() == 4) {
            columnAfter = BLUE_MOVES_4R[columnBefore];
        } /*else if(dimensions.getNrOfRows() == 6) {
            columnAfter = RED_MOVES_6R[columnBefore];
        }*/
        else {
            throw new IllegalArgumentException();
        }
        assert ValidColumnStateChecker.isValid4RowColumnState(columnAfter) : "Not a valid column: " + columnAfter;
        return columnAfter;
    }
}
