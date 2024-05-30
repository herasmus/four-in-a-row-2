package dk.htr.games.minmax.four_in_row.bits;

import dk.htr.games.minmax.four_in_row.exceptions.BitException;

import static dk.htr.games.minmax.four_in_row.board.BoardState.ERASE_BYTE_MASK;

public class BitOperations {

    // Create a mask: Shiftamount 3 => 0000 0111
    public static int getNTimesOneRightMask(int shiftAmount) {
        return (1 << shiftAmount) - 1;
    }

    public static int getBit(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        int value = input & mask;
        return value >> (bitPos - 1);
    }

    public static int turnOn(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        return input | mask;
    }

    protected static int turnOff(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        int invertedMask = ~mask;
        return input & invertedMask;
    }

    public static int setBit(int input, int bitPos, int value) throws BitException {
        return switch (value) {
            case 0 -> turnOff(input, bitPos);
            case 1 -> turnOn(input, bitPos);
            default -> throw new BitException("Value out of range for a bit");
        };
    }

    public static int readByte(long input, int byteNr) {
        long rightShifted = input >> ((byteNr - 1) * 8);
        return (int)(rightShifted & 0b11111111);
    }

    public static long writeByte(long input, int byteNr, int move) {
        int nfOfBitsToShift = (move - 1) * 8;
        long leftShifted = (long) byteNr << nfOfBitsToShift;
        input = input & ERASE_BYTE_MASK[move - 1];
        return input | leftShifted;
    }
}
