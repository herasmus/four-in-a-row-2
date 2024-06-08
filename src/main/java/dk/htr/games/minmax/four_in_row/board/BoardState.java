package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.readByte;
import static dk.htr.games.minmax.four_in_row.board.ColumnOperations.addColumnStr;

public class BoardState {

    private static void addRowNumbers(GameDimensions dimensions, String[] rowStrings) {
        for(int rowNumber = 1; rowNumber <= dimensions.nrOfRows(); rowNumber++) {
            rowStrings[rowNumber - 1] = " " + (dimensions.nrOfRows() - rowNumber + 1) + "| ";
        }
    }

    private static void addBottomLine(GameDimensions dimensions, String[] rowStrings) {
        int nrOfColumns = dimensions.nrOfColumns();
        rowStrings[dimensions.nrOfRows()] = " " + String.valueOf('-').repeat((nrOfColumns + 1) * 2 + 1);
    }

    private static void addColumnNumbers(GameDimensions dimensions, String[] rowStrings) {
        rowStrings[dimensions.nrOfRows() + 1] = "    ";
        for(int columnNr = 1; columnNr <= dimensions.nrOfColumns(); columnNr++) {
            rowStrings[dimensions.nrOfRows() + 1] += columnNr + " ";
        }
    }

    /*
     *  Example: 7 x 6
     *
     *  If the column isn't full, then bit 7 and 6,
     *  and all of the bits of same value in bit 5 and below
     *  (until another bitvalue is encountered) to be considered as empty counters
     *  denoted by a '.'
     *  1 = 'x'
     *  0 = 'o'
     *
     */
    public static String[] getBoardStateStrings(long board,
                                                GameDimensions
                                                        dimensions, int move) throws GameException {
        String[] rows = new String[dimensions.nrOfRows() + 2];
        addRowNumbers(dimensions, rows);
        for (int i = 0; i < dimensions.nrOfColumns(); i++) {
            int column = readByte(board, i + 1);
            addColumnStr(column, dimensions, rows);
        }
        addBottomLine(dimensions, rows);
        addColumnNumbers(dimensions, rows);
        return rows;
    }


    private static String getEmptyColumn(GameDimensions dimensions) {
        return ".".repeat(dimensions.nrOfColumns());
    }

//    public static String getColumnStateStr(int column) {

//    }
}
