package dk.htr.games.minmax.four_in_row.board.columns.four;

/*
 *
 */
public class ValidFourRowColumns {
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
}
