package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoves;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;

public class FourRowColumnMove implements ColumnMoves {
    final protected static int[]  RED_MOVES_4R;
    final protected static int[]  BLUE_MOVES_4R;

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
        RED_MOVES_4R[COLUMN_EMPTY]  = COLUMN_O;
        BLUE_MOVES_4R[COLUMN_EMPTY] = COLUMN_X;

        // 1 counter -> 2 counters
        RED_MOVES_4R[COLUMN_O]  = COLUMN_OO;
        RED_MOVES_4R[COLUMN_X]  = COLUMN_OX;
        BLUE_MOVES_4R[COLUMN_O] = COLUMN_XO;
        BLUE_MOVES_4R[COLUMN_X] = COLUMN_XX;

        // 2 counter -> 3 counters
        RED_MOVES_4R[COLUMN_OO]  = COLUMN_OOO;
        RED_MOVES_4R[COLUMN_OX]  = COLUMN_OOX;
        RED_MOVES_4R[COLUMN_XO]  = COLUMN_OXO;
        RED_MOVES_4R[COLUMN_XX]  = COLUMN_OXX;
        BLUE_MOVES_4R[COLUMN_OO] = COLUMN_XOO;
        BLUE_MOVES_4R[COLUMN_OX] = COLUMN_XOX;
        BLUE_MOVES_4R[COLUMN_XO] = COLUMN_XXO;
        BLUE_MOVES_4R[COLUMN_XX] = COLUMN_XXX;

        // 3 counter -> 4 counters
        // Red move
        RED_MOVES_4R[COLUMN_OOO] = COLUMN_4R_OOOO;
        RED_MOVES_4R[COLUMN_OOX] = COLUMN_4R_OOOX;
        RED_MOVES_4R[COLUMN_OXO] = COLUMN_4R_OOXO;
        RED_MOVES_4R[COLUMN_OXX] = COLUMN_4R_OOXX;
        RED_MOVES_4R[COLUMN_XOO] = COLUMN_4R_OXOO;
        RED_MOVES_4R[COLUMN_XOX] = COLUMN_4R_OXOX;
        RED_MOVES_4R[COLUMN_XXO] = COLUMN_4R_OXXO;
        RED_MOVES_4R[COLUMN_XXX] = COLUMN_4R_OXXX;

        // 3 counter -> 4 counters
        // Blue move
        BLUE_MOVES_4R[COLUMN_OOO] = COLUMN_4R_XOOO;
        BLUE_MOVES_4R[COLUMN_OOX] = COLUMN_4R_XOOX;
        BLUE_MOVES_4R[COLUMN_OXO] = COLUMN_4R_XOXO;
        BLUE_MOVES_4R[COLUMN_OXX] = COLUMN_4R_XOXX;
        BLUE_MOVES_4R[COLUMN_XOO] = COLUMN_4R_XXOO;
        BLUE_MOVES_4R[COLUMN_XOX] = COLUMN_4R_XXOX;
        BLUE_MOVES_4R[COLUMN_XXO] = COLUMN_4R_XXXO;
        BLUE_MOVES_4R[COLUMN_XXX] = COLUMN_4R_XXXX;
    }

    public int makeMoveBlue(int presentState) throws BoardStateException {
        int moveResult = BLUE_MOVES_4R[presentState];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (blue). Column before move: " + presentState);
        }
        return  moveResult;
    }

    public int makeMoveRed(int presentState) throws BoardStateException {
        int moveResult = BLUE_MOVES_4R[presentState];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (red). Column before move: " + presentState);
        }
        return  moveResult;
    }
}
