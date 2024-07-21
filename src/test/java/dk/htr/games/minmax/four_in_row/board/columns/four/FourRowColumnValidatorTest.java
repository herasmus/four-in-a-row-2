package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnValidator;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourRowColumnValidatorTest {
    FourRowColumnValidator validator = new FourRowColumnValidator();

    @Test
    public void outOfBoundsLessThanZero() {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            validator.isValidColumn(-1);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Column state cant be less than 0x00", thrown.getMessage());
    }

    @Test
    public void outOfBoundsMoreThan0xFF() {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            validator.isValidColumn(0x100);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Column state cant be greater than 0xFF", thrown.getMessage());
    }

    @Test
    public void isValidColumn4Rows() throws BoardStateException {
        // Failure
        assertFalse(validator.isValidColumn(0x00));  // 0b00000000

        // Success
        assertTrue(validator.isValidColumn(0x01));   // 0b00000001
        assertTrue(validator.isValidColumn(0x02));   // b000000010
        assertTrue(validator.isValidColumn(0x03));   // 0b00000011
        assertTrue(validator.isValidColumn(0x04));   // 0b00000100
        assertTrue(validator.isValidColumn(0x05));   // 0b00000101
        assertTrue(validator.isValidColumn(0x06));   // 0b00000110
        assertTrue(validator.isValidColumn(0x07));   // 0b00000111

        // Failure
        assertFalse(validator.isValidColumn(0x08));  // 0b00001000
        assertFalse(validator.isValidColumn(0x09));  // 0b00001001
        assertFalse(validator.isValidColumn(0x0A));  // 0b00001010
        assertFalse(validator.isValidColumn(0x0B));  // 0b00001011
        assertFalse(validator.isValidColumn(0x0C));  // 0b00001100
        assertFalse(validator.isValidColumn(0x0D));  // 0b00001101
        assertFalse(validator.isValidColumn(0x0E));  // 0b00001110
        assertFalse(validator.isValidColumn(0x0F));  // 0b00001111
        assertFalse(validator.isValidColumn(0x10));  // 0b00010000
        assertFalse(validator.isValidColumn(0x11));  // 0b00010001
        assertFalse(validator.isValidColumn(0x12));  // 0b00010010
        assertFalse(validator.isValidColumn(0x13));  // 0b00010011
        assertFalse(validator.isValidColumn(0x14));  // 0b00010100
        assertFalse(validator.isValidColumn(0x15));  // 0b00010101
        assertFalse(validator.isValidColumn(0x16));  // 0b00010110
        assertFalse(validator.isValidColumn(0x17));  // 0b00010111
        assertFalse(validator.isValidColumn(0x18));  // 0b00011000
        assertFalse(validator.isValidColumn(0x19));  // 0b00011001
        assertFalse(validator.isValidColumn(0x1A));  // 0b00011010
        assertFalse(validator.isValidColumn(0x1B));  // 0b00011011
        assertFalse(validator.isValidColumn(0x1C));  // 0b00011100
        assertFalse(validator.isValidColumn(0x1D));  // 0b00011101
        assertFalse(validator.isValidColumn(0x1E));  // 0b00011110
        assertFalse(validator.isValidColumn(0x1F));  // 0b00011111
        assertFalse(validator.isValidColumn(0x20));  // 0b00100000
        assertFalse(validator.isValidColumn(0x21));  // 0b00100001
        assertFalse(validator.isValidColumn(0x22));  // b000100010
        assertFalse(validator.isValidColumn(0x23));  // 0b00100011
        assertFalse(validator.isValidColumn(0x24));  // 0b00100100
        assertFalse(validator.isValidColumn(0x25));  // 0b00100101
        assertFalse(validator.isValidColumn(0x26));  // 0b00100110
        assertFalse(validator.isValidColumn(0x27));  // 0b00100111
        assertFalse(validator.isValidColumn(0x28));  // 0b00101000
        assertFalse(validator.isValidColumn(0x29));  // 0b00101001
        assertFalse(validator.isValidColumn(0x2A));  // 0b00101010
        assertFalse(validator.isValidColumn(0x2B));  // 0b00101011
        assertFalse(validator.isValidColumn(0x2C));  // 0b00101100
        assertFalse(validator.isValidColumn(0x2D));  // 0b00101101
        assertFalse(validator.isValidColumn(0x2E));  // 0b00101110
        assertFalse(validator.isValidColumn(0x2F));  // 0b00101111
        assertFalse(validator.isValidColumn(0x30));  // 0b00110000
        assertFalse(validator.isValidColumn(0x31));  // 0b00110001
        assertFalse(validator.isValidColumn(0x32));  // 0b00110010
        assertFalse(validator.isValidColumn(0x33));  // 0b00110011
        assertFalse(validator.isValidColumn(0x34));  // 0b00110100
        assertFalse(validator.isValidColumn(0x35));  // 0b00110101
        assertFalse(validator.isValidColumn(0x36));  // 0b00110110
        assertFalse(validator.isValidColumn(0x37));  // 0b00110111
        assertFalse(validator.isValidColumn(0x38));  // 0b00111000
        assertFalse(validator.isValidColumn(0x39));  // 0b00111001
        assertFalse(validator.isValidColumn(0x3A));  // 0b00111010
        assertFalse(validator.isValidColumn(0x3B));  // 0b00111011
        assertFalse(validator.isValidColumn(0x3C));  // 0b00111100
        assertFalse(validator.isValidColumn(0x3D));  // 0b00111101
        assertFalse(validator.isValidColumn(0x3E));  // 0b00111110
        assertFalse(validator.isValidColumn(0x3F));  // 0b00111111
        assertFalse(validator.isValidColumn(0x40));  // 0b01000000   64
        assertFalse(validator.isValidColumn(0x41));  // 0b01000001
        assertFalse(validator.isValidColumn(0x42));  // b001000010
        assertFalse(validator.isValidColumn(0x43));  // 0b01000011
        assertFalse(validator.isValidColumn(0x44));  // 0b01000100
        assertFalse(validator.isValidColumn(0x45));  // 0b01000101
        assertFalse(validator.isValidColumn(0x46));  // 0b01000110
        assertFalse(validator.isValidColumn(0x47));  // 0b01000111
        assertFalse(validator.isValidColumn(0x48));  // 0b01001000
        assertFalse(validator.isValidColumn(0x49));  // 0b01001001
        assertFalse(validator.isValidColumn(0x4A));  // 0b01001010
        assertFalse(validator.isValidColumn(0x4B));  // 0b01001011
        assertFalse(validator.isValidColumn(0x4C));  // 0b01001100
        assertFalse(validator.isValidColumn(0x4D));  // 0b01001101
        assertFalse(validator.isValidColumn(0x4E));  // 0b01001101
        assertFalse(validator.isValidColumn(0x4F));  // 0b01001111
        assertFalse(validator.isValidColumn(0x50));  // 0b01010000   80
        assertFalse(validator.isValidColumn(0x51));  // 0b01010001
        assertFalse(validator.isValidColumn(0x52));  // b001010010
        assertFalse(validator.isValidColumn(0x53));  // 0b01010011
        assertFalse(validator.isValidColumn(0x54));  // 0b01010100
        assertFalse(validator.isValidColumn(0x55));  // 0b01010101
        assertFalse(validator.isValidColumn(0x56));  // 0b01010110
        assertFalse(validator.isValidColumn(0x57));  // 0b01010111
        assertFalse(validator.isValidColumn(0x58));  // 0b01011000
        assertFalse(validator.isValidColumn(0x59));  // 0b01011001
        assertFalse(validator.isValidColumn(0x5A));  // 0b01011010
        assertFalse(validator.isValidColumn(0x5B));  // 0b01011011
        assertFalse(validator.isValidColumn(0x5C));  // 0b01011100
        assertFalse(validator.isValidColumn(0x5D));  // 0b01011101
        assertFalse(validator.isValidColumn(0x5E));  // 0b01011101
        assertFalse(validator.isValidColumn(0x5F));  // 0b01011111
        assertFalse(validator.isValidColumn(0x60));  // 0b01100000   96
        assertFalse(validator.isValidColumn(0x61));  // 0b01100001
        assertFalse(validator.isValidColumn(0x62));  // b001100010
        assertFalse(validator.isValidColumn(0x63));  // 0b01100011
        assertFalse(validator.isValidColumn(0x64));  // 0b01100100
        assertFalse(validator.isValidColumn(0x65));  // 0b01100101
        assertFalse(validator.isValidColumn(0x66));  // 0b01100110
        assertFalse(validator.isValidColumn(0x67));  // 0b01100111
        assertFalse(validator.isValidColumn(0x68));  // 0b01101000
        assertFalse(validator.isValidColumn(0x69));  // 0b01101001
        assertFalse(validator.isValidColumn(0x6A));  // 0b01101010
        assertFalse(validator.isValidColumn(0x6B));  // 0b01101011
        assertFalse(validator.isValidColumn(0x6C));  // 0b01101100
        assertFalse(validator.isValidColumn(0x6D));  // 0b01101101
        assertFalse(validator.isValidColumn(0x6E));  // 0b01101101
        assertFalse(validator.isValidColumn(0x6F));  // 0b01101111
        assertFalse(validator.isValidColumn(0x70));  // 0b01110000   112
        assertFalse(validator.isValidColumn(0x71));  // 0b01110001
        assertFalse(validator.isValidColumn(0x72));  // b001110010
        assertFalse(validator.isValidColumn(0x73));  // 0b01110011
        assertFalse(validator.isValidColumn(0x74));  // 0b01110100
        assertFalse(validator.isValidColumn(0x75));  // 0b01110101
        assertFalse(validator.isValidColumn(0x76));  // 0b01110110
        assertFalse(validator.isValidColumn(0x77));  // 0b01110111

        // Success
        assertTrue(validator.isValidColumn(0x78));  // 0b01111000
        assertTrue(validator.isValidColumn(0x79));  // 0b01111001
        assertTrue(validator.isValidColumn(0x7A));  // 0b01111010
        assertTrue(validator.isValidColumn(0x7B));  // 0b01111011
        assertTrue(validator.isValidColumn(0x7C));  // 0b01111100
        assertTrue(validator.isValidColumn(0x7D));  // 0b01111101
        assertTrue(validator.isValidColumn(0x7E));  // 0b01111110

        // Failure
        assertFalse(validator.isValidColumn(0x7F));  // 0b01111111

        // Success (empty)
        assertTrue(validator.isValidColumn(0x80));  // 0b10000000  128

        // Failure
        assertFalse(validator.isValidColumn(0x81));   // 0b10000001
        assertFalse(validator.isValidColumn(0x82));   // b010000010
        assertFalse(validator.isValidColumn(0x83));   // 0b10000011
        assertFalse(validator.isValidColumn(0x84));   // 0b10000100
        assertFalse(validator.isValidColumn(0x85));   // 0b10000101
        assertFalse(validator.isValidColumn(0x86));   // 0b10000110
        assertFalse(validator.isValidColumn(0x87));   // 0b10000111
        assertFalse(validator.isValidColumn(0x88));   // 0b10001000
        assertFalse(validator.isValidColumn(0x89));   // 0b10001001
        assertFalse(validator.isValidColumn(0x8A));   // 0b10001010
        assertFalse(validator.isValidColumn(0x8B));   // 0b10001011
        assertFalse(validator.isValidColumn(0x8C));   // 0b10001100
        assertFalse(validator.isValidColumn(0x8D));   // 0b10001101
        assertFalse(validator.isValidColumn(0x8E));   // 0b10001110
        assertFalse(validator.isValidColumn(0x8F));   // 0b10001111
        assertFalse(validator.isValidColumn(0x90));   // 0b10010000  144
        assertFalse(validator.isValidColumn(0x91));   // 0b10010001
        assertFalse(validator.isValidColumn(0x92));   // b010010010
        assertFalse(validator.isValidColumn(0x93));   // 0b10010011
        assertFalse(validator.isValidColumn(0x94));   // 0b10010100
        assertFalse(validator.isValidColumn(0x95));   // 0b10010101
        assertFalse(validator.isValidColumn(0x96));   // 0b10010110
        assertFalse(validator.isValidColumn(0x97));   // 0b10010111
        assertFalse(validator.isValidColumn(0x98));   // 0b10011000
        assertFalse(validator.isValidColumn(0x99));   // 0b10011001
        assertFalse(validator.isValidColumn(0x9A));   // 0b10011010
        assertFalse(validator.isValidColumn(0x9B));   // 0b10011011
        assertFalse(validator.isValidColumn(0x9C));   // 0b10011100
        assertFalse(validator.isValidColumn(0x9D));   // 0b10011101
        assertFalse(validator.isValidColumn(0x9E));   // 0b10011110
        assertFalse(validator.isValidColumn(0x9F));   // 0b10011111
        assertFalse(validator.isValidColumn(0xA0));   // 0b10100000  160
        assertFalse(validator.isValidColumn(0xA1));   // 0b10100001
        assertFalse(validator.isValidColumn(0xA2));   // b010100010
        assertFalse(validator.isValidColumn(0xA3));   // 0b10100011
        assertFalse(validator.isValidColumn(0xA4));   // 0b10100100
        assertFalse(validator.isValidColumn(0xA5));   // 0b10100101
        assertFalse(validator.isValidColumn(0xA6));   // 0b10100110
        assertFalse(validator.isValidColumn(0xA7));   // 0b10100111
        assertFalse(validator.isValidColumn(0xA8));   // 0b10101000
        assertFalse(validator.isValidColumn(0xA9));   // 0b10101001
        assertFalse(validator.isValidColumn(0xAA));   // 0b10101010
        assertFalse(validator.isValidColumn(0xAB));   // 0b10101011
        assertFalse(validator.isValidColumn(0xAC));   // 0b10101100
        assertFalse(validator.isValidColumn(0xAD));   // 0b10101101
        assertFalse(validator.isValidColumn(0xAE));   // 0b10101110
        assertFalse(validator.isValidColumn(0xAF));   // 0b10101111
        assertFalse(validator.isValidColumn(0xB0));   // 0b10110000  176
        assertFalse(validator.isValidColumn(0xB1));   // 0b10110001
        assertFalse(validator.isValidColumn(0xB2));   // b010110010
        assertFalse(validator.isValidColumn(0xB3));   // 0b10110011
        assertFalse(validator.isValidColumn(0xB4));   // 0b10110100
        assertFalse(validator.isValidColumn(0xB5));   // 0b10110101
        assertFalse(validator.isValidColumn(0xB6));   // 0b10110110
        assertFalse(validator.isValidColumn(0xB7));   // 0b10110111
        assertFalse(validator.isValidColumn(0xB8));   // 0b10111000
        assertFalse(validator.isValidColumn(0xB9));   // 0b10111001
        assertFalse(validator.isValidColumn(0xBA));   // 0b10111010
        assertFalse(validator.isValidColumn(0xBB));   // 0b10111011
        assertFalse(validator.isValidColumn(0xBC));   // 0b10111100
        assertFalse(validator.isValidColumn(0xBD));   // 0b10111101
        assertFalse(validator.isValidColumn(0xBE));   // 0b10111110
        assertFalse(validator.isValidColumn(0xBF));   // 0b10111111

        // Success
        assertTrue(validator.isValidColumn(0xC0));   // 0b11000000  192
        assertTrue(validator.isValidColumn(0xC1));   // 0b11000001
        assertTrue(validator.isValidColumn(0xC2));   // b011000010
        assertTrue(validator.isValidColumn(0xC3));   // 0b11000011
        assertTrue(validator.isValidColumn(0xC4));   // 0b11000100
        assertTrue(validator.isValidColumn(0xC5));   // 0b11000101
        assertTrue(validator.isValidColumn(0xC6));   // 0b11000110
        assertTrue(validator.isValidColumn(0xC7));   // 0b11000111
        assertTrue(validator.isValidColumn(0xC8));   // 0b11001000
        assertTrue(validator.isValidColumn(0xC9));   // 0b11001001
        assertTrue(validator.isValidColumn(0xCA));   // 0b11001010
        assertTrue(validator.isValidColumn(0xCB));   // 0b11001011
        assertTrue(validator.isValidColumn(0xCC));   // 0b11001100
        assertTrue(validator.isValidColumn(0xCD));   // 0b11001101
        assertTrue(validator.isValidColumn(0xCE));   // 0b11001110
        assertTrue(validator.isValidColumn(0xCF));   // 0b11001111

        // Failure
        assertFalse(validator.isValidColumn(0xD0));   // 0b11010000  208
        assertFalse(validator.isValidColumn(0xD1));   // 0b11010001
        assertFalse(validator.isValidColumn(0xD2));   // b011010010
        assertFalse(validator.isValidColumn(0xD3));   // 0b11010011
        assertFalse(validator.isValidColumn(0xD4));   // 0b11010100
        assertFalse(validator.isValidColumn(0xD5));   // 0b11010101
        assertFalse(validator.isValidColumn(0xD6));   // 0b110!0110
        assertFalse(validator.isValidColumn(0xD7));   // 0b110!0111
        assertFalse(validator.isValidColumn(0xD8));   // 0b110!1000
        assertFalse(validator.isValidColumn(0xD9));   // 0b110!1001
        assertFalse(validator.isValidColumn(0xDA));   // 0b11011010
        assertFalse(validator.isValidColumn(0xDB));   // 0b11011011
        assertFalse(validator.isValidColumn(0xDC));   // 0b11011100
        assertFalse(validator.isValidColumn(0xDD));   // 0b11011101
        assertFalse(validator.isValidColumn(0xDE));   // 0b11011110
        assertFalse(validator.isValidColumn(0xDF));   // 0b11011111
        assertFalse(validator.isValidColumn(0xE0));   // 0b11100000  224
        assertFalse(validator.isValidColumn(0xE1));   // 0b11100001
        assertFalse(validator.isValidColumn(0xE2));   // b011100010
        assertFalse(validator.isValidColumn(0xE3));   // 0b11100011
        assertFalse(validator.isValidColumn(0xE4));   // 0b11100100
        assertFalse(validator.isValidColumn(0xE5));   // 0b11100101
        assertFalse(validator.isValidColumn(0xE6));   // 0b11100110
        assertFalse(validator.isValidColumn(0xE7));   // 0b11100111
        assertFalse(validator.isValidColumn(0xE8));   // 0b11101000
        assertFalse(validator.isValidColumn(0xE9));   // 0b11101001
        assertFalse(validator.isValidColumn(0xEA));   // 0b11101010
        assertFalse(validator.isValidColumn(0xEB));   // 0b11101011
        assertFalse(validator.isValidColumn(0xEC));   // 0b11101100
        assertFalse(validator.isValidColumn(0xED));   // 0b11101101
        assertFalse(validator.isValidColumn(0xEE));   // 0b11101110
        assertFalse(validator.isValidColumn(0xEF));   // 0b11101111
        assertFalse(validator.isValidColumn(0xF0));   // 0b11110000  240
        assertFalse(validator.isValidColumn(0xF1));   // 0b11110001
        assertFalse(validator.isValidColumn(0xF2));   // b011110010
        assertFalse(validator.isValidColumn(0xF3));   // 0b11110011
        assertFalse(validator.isValidColumn(0xF4));   // 0b11110100
        assertFalse(validator.isValidColumn(0xF5));   // 0b11110101
        assertFalse(validator.isValidColumn(0xF6));   // 0b11110110
        assertFalse(validator.isValidColumn(0xF7));   // 0b11110111
        assertFalse(validator.isValidColumn(0xF8));   // 0b11111000
        assertFalse(validator.isValidColumn(0xF9));   // 0b11111001
        assertFalse(validator.isValidColumn(0xFA));   // 0b11111010
        assertFalse(validator.isValidColumn(0xFB));   // 0b11111011
        assertFalse(validator.isValidColumn(0xFC));   // 0b11111100
        assertFalse(validator.isValidColumn(0xFD));   // 0b11111101
        assertFalse(validator.isValidColumn(0xFE));   // 0b11111110
        assertFalse(validator.isValidColumn(0xFF));   // 0b11111111
    }
}
