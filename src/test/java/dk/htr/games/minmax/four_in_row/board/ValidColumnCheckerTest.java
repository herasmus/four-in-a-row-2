package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidColumnCheckerTest {
    @Test
    public void isValidColumn4Rows() {
        // Failure
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x00));  // 0b00000000

        // Success
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x01));   // 0b00000001
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x02));   // b000000010
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x03));   // 0b00000011
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x04));   // 0b00000100
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x05));   // 0b00000101
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x06));   // 0b00000110
        assertTrue(ValidColumnChecker.isValid4RowColumn(0x07));   // 0b00000111

        // Failure
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x08));  // 0b00001000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x09));  // 0b00001001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0A));  // 0b00001010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0B));  // 0b00001011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0C));  // 0b00001100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0D));  // 0b00001101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0E));  // 0b00001110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x0F));  // 0b00001111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x10));  // 0b00010000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x11));  // 0b00010001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x12));  // 0b00010010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x13));  // 0b00010011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x14));  // 0b00010100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x15));  // 0b00010101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x16));  // 0b00010110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x17));  // 0b00010111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x18));  // 0b00011000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x19));  // 0b00011001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1A));  // 0b00011010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1B));  // 0b00011011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1C));  // 0b00011100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1D));  // 0b00011101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1E));  // 0b00011110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x1F));  // 0b00011111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x20));  // 0b00100000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x21));  // 0b00100001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x22));  // b000100010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x23));  // 0b00100011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x24));  // 0b00100100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x25));  // 0b00100101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x26));  // 0b00100110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x27));  // 0b00100111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x28));  // 0b00101000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x29));  // 0b00101001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2A));  // 0b00101010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2B));  // 0b00101011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2C));  // 0b00101100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2D));  // 0b00101101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2E));  // 0b00101110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x2F));  // 0b00101111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x30));  // 0b00110000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x31));  // 0b00110001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x32));  // 0b00110010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x33));  // 0b00110011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x34));  // 0b00110100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x35));  // 0b00110101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x36));  // 0b00110110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x37));  // 0b00110111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x38));  // 0b00111000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x39));  // 0b00111001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3A));  // 0b00111010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3B));  // 0b00111011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3C));  // 0b00111100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3D));  // 0b00111101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3E));  // 0b00111110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x3F));  // 0b00111111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x40));  // 0b01000000   64
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x41));  // 0b01000001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x42));  // b001000010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x43));  // 0b01000011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x44));  // 0b01000100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x45));  // 0b01000101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x46));  // 0b01000110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x47));  // 0b01000111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x48));  // 0b01001000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x49));  // 0b01001001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4A));  // 0b01001010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4B));  // 0b01001011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4C));  // 0b01001100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4D));  // 0b01001101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4E));  // 0b01001101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x4F));  // 0b01001111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x50));  // 0b01010000   80
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x51));  // 0b01010001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x52));  // b001010010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x53));  // 0b01010011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x54));  // 0b01010100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x55));  // 0b01010101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x56));  // 0b01010110
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x57));  // 0b01010111
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x58));  // 0b01011000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x59));  // 0b01011001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5A));  // 0b01011010
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5B));  // 0b01011011
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5C));  // 0b01011100
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5D));  // 0b01011101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5E));  // 0b01011101
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x5F));  // 0b01011111

        fail();


        assertFalse(ValidColumnChecker.isValid4RowColumn(0x60));  // 0b01100000
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x31));  // 0b01100001
        assertFalse(ValidColumnChecker.isValid4RowColumn(0x32));  // b001100010
        fail();
        assertFalse(ValidColumnChecker.isValid4RowColumn(35));  // 0b00100011
        assertFalse(ValidColumnChecker.isValid4RowColumn(36));  // 0b00100100
        assertFalse(ValidColumnChecker.isValid4RowColumn(37));  // 0b00100101
        assertFalse(ValidColumnChecker.isValid4RowColumn(38));  // 0b00100110
        assertFalse(ValidColumnChecker.isValid4RowColumn(39));  // 0b00100111
        assertFalse(ValidColumnChecker.isValid4RowColumn(40));  // 0b00101000
        assertFalse(ValidColumnChecker.isValid4RowColumn(41));  // 0b00101001
        fail();
        assertFalse(ValidColumnChecker.isValid4RowColumn(42));  // 0b00101010
        assertFalse(ValidColumnChecker.isValid4RowColumn(43));  // 0b00101011
        assertFalse(ValidColumnChecker.isValid4RowColumn(44));  // 0b00101100
        assertFalse(ValidColumnChecker.isValid4RowColumn(45));  // 0b00101101
        assertFalse(ValidColumnChecker.isValid4RowColumn(46));  // 0b00101110
        assertFalse(ValidColumnChecker.isValid4RowColumn(47));  // 0b00101111


    }
}
