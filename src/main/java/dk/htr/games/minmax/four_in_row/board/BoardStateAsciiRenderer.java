package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import jdk.jshell.spi.ExecutionControl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.readByte;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class BoardStateAsciiRenderer {
    private final GameDimensions dimensions;
    private final ColumnStringOperations columnOperations;

    private void addRowNumbers(String[] rowStrings) {
        for(int rowNumber = 1; rowNumber <= dimensions.getNrOfRows(); rowNumber++) {
            rowStrings[rowNumber - 1] = " " + (dimensions.getNrOfRows() - rowNumber + 1) + "| ";
        }
    }

    private void addBottomLine(String[] rowStrings) {
        int nrOfColumns = dimensions.getNrOfColumns();
        rowStrings[dimensions.getNrOfRows()] = " " + String.valueOf('-').repeat((nrOfColumns + 1) * 2 + 1);
    }

    private void addColumnNumbers(String[] rowStrings) {
        rowStrings[dimensions.getNrOfRows() + 1] = "    ";
        for(int columnNr = 1; columnNr <= dimensions.getNrOfColumns(); columnNr++) {
            rowStrings[dimensions.getNrOfRows() + 1] += columnNr + " ";
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
    public String[] getBoardStateAsciiImage(long board) throws GameException {
        String[] rows = new String[dimensions.getNrOfRows() + 2];
        addRowNumbers(rows);
        for (int i = 0; i < dimensions.getNrOfColumns(); i++) {
            int columnState = readByte(board, i);
            columnOperations.addColumnStr(columnState, rows);
        }
        addBottomLine(rows);
        addColumnNumbers(rows);
        return rows;
    }


    //private String getEmptyColumn() {
     //   return ".".repeat(dimensions.getNrOfColumns());
   // }

//    public static String getColumnStateStr(int column) {

//    }

    protected boolean isBoardValid(long board) throws GameException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Needs to be implemented");
  /*     for(int column = 0; column < dimensions.getNrOfColumns(); column++) {
            if(!ValidColumnStateChecker.isValidColumnState(column, dimensions.getNrOfRows())) {
                throw new BoardStateException("Board invalid. Column (1 based)");
            }
        }
        return true;*/
    }

    public long move(long boardBefore, int move) {
        return -1;
    }
}
