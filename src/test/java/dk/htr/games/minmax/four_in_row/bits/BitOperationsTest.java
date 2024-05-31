package dk.htr.games.minmax.four_in_row.bits;

import dk.htr.games.minmax.four_in_row.board.BoardHandler;
import dk.htr.games.minmax.four_in_row.board.BoardState;
import dk.htr.games.minmax.four_in_row.exceptions.BitException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.bits.BitOperations.readByte;
import static dk.htr.games.minmax.four_in_row.bits.BitOperations.writeByte;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitOperationsTest {
    @Test
    public void getColumnBit() {
        assertEquals(1, BitOperations.getBit(0b11101101, 1));
        assertEquals(0, BitOperations.getBit(0b11101101, 2));
        assertEquals(1, BitOperations.getBit(0b11101101, 3));
        assertEquals(1, BitOperations.getBit(0b11101101, 4));
        assertEquals(0, BitOperations.getBit(0b11101101, 5));
        assertEquals(1, BitOperations.getBit(0b11101101, 6));
    }

    @Test
    public void turnOn() {
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 1));
        assertEquals(0b11101111, BitOperations.turnOn(0b11101101, 2));
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 3));
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 4));
        assertEquals(0b11111101, BitOperations.turnOn(0b11101101, 5));
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 6));
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 7));
        assertEquals(0b11101101, BitOperations.turnOn(0b11101101, 8));
    }

    @Test
    public void turnOff() {
        assertEquals(0b11101100, BitOperations.turnOff(0b11101101, 1));
        assertEquals(0b11101101, BitOperations.turnOff(0b11101101, 2));
        assertEquals(0b11101001, BitOperations.turnOff(0b11101101, 3));
        assertEquals(0b11100101, BitOperations.turnOff(0b11101101, 4));
        assertEquals(0b11101101, BitOperations.turnOff(0b11101101, 5));
        assertEquals(0b11001101, BitOperations.turnOff(0b11101101, 6));
        assertEquals(0b10101101, BitOperations.turnOff(0b11101101, 7));
        assertEquals(0b01101101, BitOperations.turnOff(0b11101101, 8));
    }

    @Test
    public void setBit() throws BitException {
        assertEquals(0b11101100, BitOperations.setBit(0b11101101, 1, 0));
        assertEquals(0b11101101, BitOperations.setBit(0b11101101, 1, 1));
        assertEquals(0b11101101, BitOperations.setBit(0b11101101, 2, 0));
        assertEquals(0b11101111, BitOperations.setBit(0b11101101, 2, 1));
        assertEquals(0b11101001, BitOperations.setBit(0b11101101, 3, 0));
        assertEquals(0b11101101, BitOperations.setBit(0b11101101, 3, 1));
        assertEquals(0b11100101, BitOperations.setBit(0b11101101, 4, 0));
        assertEquals(0b11101101, BitOperations.setBit(0b11101101, 4, 1));
    }

    @Test
    public void readColumn() {
        final long board = 0b00111010_00000001_00111110_10000000_01001101L;

        int expected = 0b01001101;
        int got = readByte(board, 0);
        assertEquals(expected, got);

        expected = 0b10000000;
        got = readByte(board, 1);
        assertEquals(expected, got);

        expected = 0b00111110;
        got = readByte(board, 2);
        assertEquals(expected, got);

        expected = 0b00000001;
        got = readByte(board, 3);
        assertEquals(expected, got);

        expected = 0b00111010;
        got = readByte(board, 4);
        assertEquals(expected, got);
    }


    @Test
    public void writeColumn() {
        final long board = 0b00111010_00000001_00111110_10000000_01001101L;
        long expected = 0b00111010_10100110_00111110_10000000_01001101L;
        long got = writeByte(board, 0b10100110, 3);
        assertEquals(expected, got);
    }
}
