package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourFowColumns.*;

public class FourRowColumnMoveExecutor implements ColumnMoveExecutor {
    final protected static int[]  RED_MOVES_4R;
    final protected static int[]  BLUE_MOVES_4R;
    FourRowColumnValidator columnValidator = new FourRowColumnValidator();

    static {
        RED_MOVES_4R = new int[256];
        for(int i = 0; i < 256; i++) {
            RED_MOVES_4R[i] = -1;
        }

        BLUE_MOVES_4R = new int[256];
        for(int i = 0; i < 256; i++) {
            BLUE_MOVES_4R[i] = -1;
        }

        // Empty -> 1 counter
        RED_MOVES_4R[COLUMN_EMPTY.getValue()]  = COLUMN_O.getValue();
        BLUE_MOVES_4R[COLUMN_EMPTY.getValue()] = COLUMN_X.getValue();

        // 1 counter -> 2 counters
        RED_MOVES_4R[COLUMN_O.getValue()]  = COLUMN_OO.getValue();
        RED_MOVES_4R[COLUMN_X.getValue()]  = COLUMN_OX.getValue();
        BLUE_MOVES_4R[COLUMN_O.getValue()] = COLUMN_XO.getValue();
        BLUE_MOVES_4R[COLUMN_X.getValue()] = COLUMN_XX.getValue();

        // 2 counter -> 3 counters
        RED_MOVES_4R[COLUMN_OO.getValue()]  = COLUMN_OOO.getValue();
        RED_MOVES_4R[COLUMN_OX.getValue()]  = COLUMN_OOX.getValue();
        RED_MOVES_4R[COLUMN_XO.getValue()]  = COLUMN_OXO.getValue();
        RED_MOVES_4R[COLUMN_XX.getValue()]  = COLUMN_OXX.getValue();
        BLUE_MOVES_4R[COLUMN_OO.getValue()] = COLUMN_XOO.getValue();
        BLUE_MOVES_4R[COLUMN_OX.getValue()] = COLUMN_XOX.getValue();
        BLUE_MOVES_4R[COLUMN_XO.getValue()] = COLUMN_XXO.getValue();
        BLUE_MOVES_4R[COLUMN_XX.getValue()] = COLUMN_XXX.getValue();

        // 3 counter -> 4 counters
        // Red move
        RED_MOVES_4R[COLUMN_OOO.getValue()] = COLUMN_4R_OOOO.getValue();
        RED_MOVES_4R[COLUMN_OOX.getValue()] = COLUMN_4R_OOOX.getValue();
        RED_MOVES_4R[COLUMN_OXO.getValue()] = COLUMN_4R_OOXO.getValue();
        RED_MOVES_4R[COLUMN_OXX.getValue()] = COLUMN_4R_OOXX.getValue();
        RED_MOVES_4R[COLUMN_XOO.getValue()] = COLUMN_4R_OXOO.getValue();
        RED_MOVES_4R[COLUMN_XOX.getValue()] = COLUMN_4R_OXOX.getValue();
        RED_MOVES_4R[COLUMN_XXO.getValue()] = COLUMN_4R_OXXO.getValue();
        RED_MOVES_4R[COLUMN_XXX.getValue()] = COLUMN_4R_OXXX.getValue();

        // 3 counter -> 4 counters
        // Blue move
        BLUE_MOVES_4R[COLUMN_OOO.getValue()] = COLUMN_4R_XOOO.getValue();
        BLUE_MOVES_4R[COLUMN_OOX.getValue()] = COLUMN_4R_XOOX.getValue();
        BLUE_MOVES_4R[COLUMN_OXO.getValue()] = COLUMN_4R_XOXO.getValue();
        BLUE_MOVES_4R[COLUMN_OXX.getValue()] = COLUMN_4R_XOXX.getValue();
        BLUE_MOVES_4R[COLUMN_XOO.getValue()] = COLUMN_4R_XXOO.getValue();
        BLUE_MOVES_4R[COLUMN_XOX.getValue()] = COLUMN_4R_XXOX.getValue();
        BLUE_MOVES_4R[COLUMN_XXO.getValue()] = COLUMN_4R_XXXO.getValue();
        BLUE_MOVES_4R[COLUMN_XXX.getValue()] = COLUMN_4R_XXXX.getValue();
    }

    public int moveBlue(int column) throws BoardStateException {
        if(!columnValidator.isValidColumn(column)) {
            throw new BoardStateException("Invalid column " + column);
        }
        int moveResult = BLUE_MOVES_4R[column];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (blue). Column before move: " + column);
        }
        return  moveResult;
    }

    public int moveRed(int column) throws BoardStateException {
        if(!columnValidator.isValidColumn(column)) {
            throw new BoardStateException("Invalid column " + column);
        }
        int moveResult = RED_MOVES_4R[column];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (red). Column before move: " + column);
        }
        return  moveResult;
    }
}
