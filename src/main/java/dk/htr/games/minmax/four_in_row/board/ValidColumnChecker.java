package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;

/**
 *
 * See TODO Document for rules
 *
 */
public class ValidColumnChecker {
    static boolean[] fourRows = new boolean[256];
    static boolean[] sixRows = new boolean[256];

    static {
        initFourRows();
        initSixRows();
    }

    private static void initFourRows() {
        int total = 0;
        fourRows[0b00000000] = false;
        total++;

        for(int i = 0b00000001; i <= 0b00000111; i++) {
            fourRows[i] = true;
            total++;
        }

        for(int i = 0b00001000; i <= 0b00001111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b00010000; i <= 0b00011111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b00100000; i <= 0b00111111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b01000000; i <= 0b01110111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b01111000; i <= 0b01111110; i++) {
            fourRows[i] = true;
            total++;
        }
        fourRows[0b01111111] = false;
        total++;
        // Empty
        fourRows[0b10000000] = true;
        total++;
        for(int i = 0b10000001; i <= 0b10111111; i++) {
            fourRows[i] = false;
            total++;
        }
        for(int i = 0b11000000; i <= 0b11101111; i++) {
            fourRows[i] = false;
            total++;
        }
        for(int i = 0b11110000; i <= 0b11111111; i++) {
            fourRows[i] = true;
            total++;
        }

        if(total != 256) throw new RuntimeException("Fatal error in initialization");
    }

    private static void initSixRows() {
        sixRows[0b00000000] = false;

        for(int i = 0b00000001; i < 0b00011111; i++) {
            sixRows[i] = true;
        }

        for(int i = 0b00100000; i < 0b00111111; i++) {
            sixRows[i] = false;
        }

        sixRows[0b00000000] = false;
        sixRows[0b00000001] = true;
        sixRows[0b00000010] = true;
        sixRows[0b00000011] = true;
        sixRows[0b00000100] = true;
        sixRows[0b00000101] = true;
        sixRows[0b00000110] = true;
        sixRows[0b00000111] = true;

        sixRows[0b00001000] = true;
        sixRows[0b00001001] = true;
        sixRows[0b00001010] = true;
        sixRows[0b00001011] = true;
        sixRows[0b00001100] = true;
        sixRows[0b00001101] = true;
        sixRows[0b00001110] = true;
        sixRows[0b00001111] = true;

        sixRows[0b00010000] = true;
        sixRows[0b00010001] = true;
        sixRows[0b00010010] = true;
        sixRows[0b00010011] = true;
        sixRows[0b00010100] = true;
        sixRows[0b00010101] = true;
        sixRows[0b00010110] = true;
        sixRows[0b00010111] = true;

        sixRows[0b00011000] = true;
        sixRows[0b00011001] = true;
        sixRows[0b00011010] = true;
        sixRows[0b00011011] = true;
        sixRows[0b00011100] = true;
        sixRows[0b00011101] = true;
        sixRows[0b00011110] = true;
        sixRows[0b00011111] = true;

        sixRows[0b00100000] = false;
        sixRows[0b00100001] = false;
        sixRows[0b00100010] = false;
        sixRows[0b00100011] = false;
        sixRows[0b00100100] = false;
        sixRows[0b00100101] = false;
        sixRows[0b00100110] = false;
        sixRows[0b00100111] = false;

        sixRows[0b00100000] = false;
        sixRows[0b00100001] = false;
        sixRows[0b00100010] = false;
        sixRows[0b00100011] = false;
        sixRows[0b00100100] = false;
        sixRows[0b00100101] = false;
        sixRows[0b00100110] = false;
        sixRows[0b00100111] = false;

    }

    public static boolean isValidColumn(int column, int numberOfRows) throws GameException {
        if(numberOfRows == 4) {
            return fourRows[column];
        } else if(numberOfRows == 6) {
            return sixRows[column];
        } else {
            throw new GameException("Doesn't handle nr of rows less than 4");
        }
    }

    public static boolean isValid4RowColumn(int column) {
        return fourRows[column];
    }
}
