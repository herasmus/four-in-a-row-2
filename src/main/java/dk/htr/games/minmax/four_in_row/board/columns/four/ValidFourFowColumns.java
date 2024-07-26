package dk.htr.games.minmax.four_in_row.board.columns.four;

public enum ValidFourFowColumns {
    PENDING(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    FAILED(4);

    private final int value;

    ValidFourFowColumns(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
