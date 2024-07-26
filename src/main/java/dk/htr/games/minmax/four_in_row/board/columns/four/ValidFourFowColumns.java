package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.CommonValidColumns;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public enum ValidFourFowColumns {
    // Common
    COLUMN_EMPTY(CommonValidColumns.COLUMN_EMPTY.getValue()),
    COLUMN_O(CommonValidColumns.COLUMN_O.getValue()),
    COLUMN_X(CommonValidColumns.COLUMN_X.getValue()),
    COLUMN_OO(CommonValidColumns.COLUMN_OO.getValue()),
    COLUMN_OX(CommonValidColumns.COLUMN_OX.getValue()),
    COLUMN_XO(CommonValidColumns.COLUMN_XO.getValue()),
    COLUMN_XX(CommonValidColumns.COLUMN_XX.getValue()),

    COLUMN_OOO(CommonValidColumns.COLUMN_OOO.getValue()),
    COLUMN_OOX(CommonValidColumns.COLUMN_OOX.getValue()),
    COLUMN_OXO(CommonValidColumns.COLUMN_OXO.getValue()),
    COLUMN_OXX(CommonValidColumns.COLUMN_OXX.getValue()),
    COLUMN_XOO(CommonValidColumns.COLUMN_XOO.getValue()),
    COLUMN_XOX(CommonValidColumns.COLUMN_XOX.getValue()),
    COLUMN_XXO(CommonValidColumns.COLUMN_XXO.getValue()),
    COLUMN_XXX(CommonValidColumns.COLUMN_XXX.getValue()),

    // specific for 4 rows column
    COLUMN_4R_OOOO(0b1100_0000),
    COLUMN_4R_OOOX(0b1100_0001),
    COLUMN_4R_OOXO(0b1100_0010),
    COLUMN_4R_OOXX(0b1100_0011),
    COLUMN_4R_OXOO(0b1100_0100),
    COLUMN_4R_OXOX(0b1100_0101),
    COLUMN_4R_OXXO(0b1100_0110),
    COLUMN_4R_OXXX(0b1100_0111),
    COLUMN_4R_XOOO(0b1100_1000),
    COLUMN_4R_XOOX(0b1100_1001),
    COLUMN_4R_XOXO(0b1100_1010),
    COLUMN_4R_XOXX(0b1100_1011),
    COLUMN_4R_XXOO(0b1100_1100),
    COLUMN_4R_XXOX(0b1100_1101),
    COLUMN_4R_XXXO(0b1100_1110),
    COLUMN_4R_XXXX(0b1100_1111);

    static final boolean[] columnValidity = new boolean[256];
    @Getter
    static final List<Integer> intValueList = new ArrayList<Integer>();
    @Getter
    private final int value;

    static {
        for (ValidFourFowColumns c : ValidFourFowColumns.values()) {
            columnValidity[c.getValue()] = true;
        }

        for (ValidFourFowColumns c : ValidFourFowColumns.values()) {
            intValueList.add(c.getValue());
        }
    }

    ValidFourFowColumns(int value) {
        this.value = value;
    }

    public static boolean isValidColumn(int column) throws BoardStateException {
        if ((column < 0)) throw new BoardStateException("Column state cant be less than 0x00");
        if ((column > 255)) throw new BoardStateException("Column state cant be greater than 0xFF");
        return columnValidity[column];
    }
}
