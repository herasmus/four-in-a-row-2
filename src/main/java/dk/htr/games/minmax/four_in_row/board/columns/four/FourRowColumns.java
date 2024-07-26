package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnValidator;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import java.util.List;

import static dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnValidator.initFourRows;

/*
 *
 */
public class FourRowColumns implements ColumnValidator {
    // Common
    final static public int COLUMN_EMPTY   = 0b1000_0000;
    final static public int COLUMN_O       = 0b0111_1110;
    final static public int COLUMN_X       = 0b0000_0001;
    final static public int COLUMN_OO      = 0b0111_1100;
    final static public int COLUMN_OX      = 0b0111_1101;
    final static public int COLUMN_XO      = 0b0000_0010;
    final static public int COLUMN_XX      = 0b0000_0011;


    final static public int COLUMN_OOO     = 0b0111_1000;
    final static public int COLUMN_OOX     = 0b0111_1001;
    final static public int COLUMN_OXO     = 0b0111_1010;
    final static public int COLUMN_OXX     = 0b0111_1011;
    final static public int COLUMN_XOO     = 0b0000_0100;
    final static public int COLUMN_XOX     = 0b0000_0101;
    final static public int COLUMN_XXO     = 0b0000_0110;
    final static public int COLUMN_XXX     = 0b0000_0111;


    // specific for 4 rows column
    final static public int COLUMN_4R_OOOO = 0b1100_0000;
    final static public int COLUMN_4R_OOOX = 0b1100_0001;
    final static public int COLUMN_4R_OOXO = 0b1100_0010;
    final static public int COLUMN_4R_OOXX = 0b1100_0011;
    final static public int COLUMN_4R_OXOO = 0b1100_0100;
    final static public int COLUMN_4R_OXOX = 0b1100_0101;
    final static public int COLUMN_4R_OXXO = 0b1100_0110;
    final static public int COLUMN_4R_OXXX = 0b1100_0111;
    final static public int COLUMN_4R_XOOO = 0b1100_1000;
    final static public int COLUMN_4R_XOOX = 0b1100_1001;
    final static public int COLUMN_4R_XOXO = 0b1100_1010;
    final static public int COLUMN_4R_XOXX = 0b1100_1011;
    final static public int COLUMN_4R_XXOO = 0b1100_1100;
    final static public int COLUMN_4R_XXOX = 0b1100_1101;
    final static public int COLUMN_4R_XXXO = 0b1100_1110;
    final static public int COLUMN_4R_XXXX = 0b1100_1111;

    private boolean[] columnValidity = new boolean[256];
    private int[] arrayOfValidColumns;

    private void createValidColumnArray() {
        arrayOfValidColumns = new int[] {
                // Empty
                COLUMN_EMPTY,
                // One Disc
                COLUMN_O,
                COLUMN_X,
                // Two Discs
                COLUMN_OO,
                COLUMN_OX,
                COLUMN_XO,
                COLUMN_XX,
                // Three Discs
                COLUMN_OOO,
                COLUMN_OOX,
                COLUMN_OXO,
                COLUMN_OXX,
                COLUMN_XOO,
                COLUMN_XOX,
                COLUMN_XXO,
                COLUMN_XXX,
                // Four Discs
                COLUMN_4R_OOOO,
                COLUMN_4R_OOOX,
                COLUMN_4R_OOXO,
                COLUMN_4R_OOXX,
                COLUMN_4R_OXOO,
                COLUMN_4R_OXOX,
                COLUMN_4R_OXXO,
                COLUMN_4R_OXXX,
                COLUMN_4R_XOOO,
                COLUMN_4R_XOOX,
                COLUMN_4R_XOXO,
                COLUMN_4R_XOXX,
                COLUMN_4R_XXOO,
                COLUMN_4R_XXOX,
                COLUMN_4R_XXXO,
                COLUMN_4R_XXXX
        };
    }

    public FourRowColumns() {
        createValidColumnArray();
        createValidColumnList();
        createInvalidColumnList();
        createColumnValidityArray();
    }

    public int[] getValidColumnArray() {
        return arrayOfValidColumns;
    }

    public List<Integer> getValidColumnList() {
        return validColumns;
    }

    public List<Integer> getInvalidColumnList() {
        return invalidColumnsLis;
    }

    public boolean isValidColumn(int column) throws BoardStateException {
        if ((column < 0)) throw new BoardStateException("Column state cant be less than 0x00");
        if ((column > 255)) throw new BoardStateException("Column state cant be greater than 0xFF");
        return columnValidity[column];
    }
}
