package dk.htr.games.minmax.four_in_row.board.columns;

public enum CommonValidColumns {
    COLUMN_EMPTY(0b1000_0000),
    COLUMN_O(0b0111_1110),
    COLUMN_X(0b0000_0001),
    COLUMN_OO(0b0111_1100),
    COLUMN_OX(0b0111_1101),
    COLUMN_XO(0b0000_0010),
    COLUMN_XX(0b0000_0011),

    COLUMN_OOO(0b0111_1000),
    COLUMN_OOX(0b0111_1001),
    COLUMN_OXO(0b0111_1010),
    COLUMN_OXX(0b0111_1011),
    COLUMN_XOO(0b0000_0100),
    COLUMN_XOX(0b0000_0101),
    COLUMN_XXO(0b0000_0110),
    COLUMN_XXX(0b0000_0111);

    private final int value;

    CommonValidColumns(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
