package dk.htr.games.minmax.four_in_row.board;

public class BinaryStringHelper {
    public static String columnStateToBinaryString(int columnState)  {
        String idBinaryString = Integer.toBinaryString(columnState);
        return String.format("%8s", idBinaryString).replace(' ', '0');
    }
}
