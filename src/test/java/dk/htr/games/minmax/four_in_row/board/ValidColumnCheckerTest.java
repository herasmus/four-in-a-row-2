package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidColumnCheckerTest {
    @Test
    public void isValidColumn4Rows() {
        // Failure
        assertFalse(ValidColumnChecker.isValid4RowColumn(0));  // 0b00000000

        // Success
        assertTrue(ValidColumnChecker.isValid4RowColumn(1));   // 0b00000001
        assertTrue(ValidColumnChecker.isValid4RowColumn(2));   // b000000010
        assertTrue(ValidColumnChecker.isValid4RowColumn(3));   // 0b00000011
        assertTrue(ValidColumnChecker.isValid4RowColumn(4));   // 0b00000100
        assertTrue(ValidColumnChecker.isValid4RowColumn(5));   // 0b00000101
        assertTrue(ValidColumnChecker.isValid4RowColumn(6));   // 0b00000110
        assertTrue(ValidColumnChecker.isValid4RowColumn(7));   // 0b00000111

        // Failure
        assertFalse(ValidColumnChecker.isValid4RowColumn(8));   // 0b00001000
        assertFalse(ValidColumnChecker.isValid4RowColumn(9));   // 0b00001001
        assertFalse(ValidColumnChecker.isValid4RowColumn(10));  // 0b00001010
        assertFalse(ValidColumnChecker.isValid4RowColumn(11));  // 0b00001011
        assertFalse(ValidColumnChecker.isValid4RowColumn(12));  // 0b00001100
        assertFalse(ValidColumnChecker.isValid4RowColumn(13));  // 0b00001101
        assertFalse(ValidColumnChecker.isValid4RowColumn(14));  // 0b00001110
        assertFalse(ValidColumnChecker.isValid4RowColumn(15));  // 0b00001111
        assertFalse(ValidColumnChecker.isValid4RowColumn(16));  // 0b00010000
        assertFalse(ValidColumnChecker.isValid4RowColumn(17));  // 0b00010001
        assertFalse(ValidColumnChecker.isValid4RowColumn(18));  // 0b00010010
        assertFalse(ValidColumnChecker.isValid4RowColumn(19));  // 0b00010011
        assertFalse(ValidColumnChecker.isValid4RowColumn(20));  // 0b00010100
        assertFalse(ValidColumnChecker.isValid4RowColumn(21));  // 0b00010101
        assertFalse(ValidColumnChecker.isValid4RowColumn(22));  // 0b00010110
        assertFalse(ValidColumnChecker.isValid4RowColumn(23));  // 0b00010111
        assertFalse(ValidColumnChecker.isValid4RowColumn(24));  // 0b00011000
        assertFalse(ValidColumnChecker.isValid4RowColumn(25));  // 0b00011001
        assertFalse(ValidColumnChecker.isValid4RowColumn(26));  // 0b00011010
        assertFalse(ValidColumnChecker.isValid4RowColumn(27));  // 0b00011011
        assertFalse(ValidColumnChecker.isValid4RowColumn(28));  // 0b00011100
        assertFalse(ValidColumnChecker.isValid4RowColumn(29));  // 0b00011101
        assertFalse(ValidColumnChecker.isValid4RowColumn(30));  // 0b00011110
        assertFalse(ValidColumnChecker.isValid4RowColumn(31));  // 0b00011111
        assertFalse(ValidColumnChecker.isValid4RowColumn(32));  // 0b00100000
        assertFalse(ValidColumnChecker.isValid4RowColumn(33));  // 0b00100001
        assertFalse(ValidColumnChecker.isValid4RowColumn(34));  // b000100010
        assertFalse(ValidColumnChecker.isValid4RowColumn(35));  // 0b00100011
        assertFalse(ValidColumnChecker.isValid4RowColumn(36));  // 0b00100100
        assertFalse(ValidColumnChecker.isValid4RowColumn(37));  // 0b00100101
        assertFalse(ValidColumnChecker.isValid4RowColumn(38));  // 0b00100110
        assertFalse(ValidColumnChecker.isValid4RowColumn(39));  // 0b00100111
        assertFalse(ValidColumnChecker.isValid4RowColumn(40));  // 0b00101000
        assertFalse(ValidColumnChecker.isValid4RowColumn(41));  // 0b00101001
        assertFalse(ValidColumnChecker.isValid4RowColumn(42));  // 0b00101010
        assertFalse(ValidColumnChecker.isValid4RowColumn(43));  // 0b00101011
        assertFalse(ValidColumnChecker.isValid4RowColumn(44));  // 0b00101100
        assertFalse(ValidColumnChecker.isValid4RowColumn(45));  // 0b00101101
        assertFalse(ValidColumnChecker.isValid4RowColumn(46));  // 0b00101110
        assertFalse(ValidColumnChecker.isValid4RowColumn(47));  // 0b00101111
        assertFalse(ValidColumnChecker.isValid4RowColumn(48));  // 0b00110000
        assertFalse(ValidColumnChecker.isValid4RowColumn(49));  // 0b00110001
        assertFalse(ValidColumnChecker.isValid4RowColumn(50));  // 0b00110010
        assertFalse(ValidColumnChecker.isValid4RowColumn(51));  // 0b00110011
        assertFalse(ValidColumnChecker.isValid4RowColumn(52));  // 0b00110100
        assertFalse(ValidColumnChecker.isValid4RowColumn(53));  // 0b00110101
        assertFalse(ValidColumnChecker.isValid4RowColumn(54));  // 0b00110110
        assertFalse(ValidColumnChecker.isValid4RowColumn(55));  // 0b00110111
        assertFalse(ValidColumnChecker.isValid4RowColumn(56));  // 0b00111000
        assertFalse(ValidColumnChecker.isValid4RowColumn(57));  // 0b00111001
        assertFalse(ValidColumnChecker.isValid4RowColumn(58));  // 0b00111010
        assertFalse(ValidColumnChecker.isValid4RowColumn(59));  // 0b00111011
        assertFalse(ValidColumnChecker.isValid4RowColumn(60));  // 0b00111100
        assertFalse(ValidColumnChecker.isValid4RowColumn(61));  // 0b00111101
        assertFalse(ValidColumnChecker.isValid4RowColumn(62));  // 0b00111110
        assertFalse(ValidColumnChecker.isValid4RowColumn(63));  // 0b00111111
        assertFalse(ValidColumnChecker.isValid4RowColumn(64));  // 0b01000000
        assertFalse(ValidColumnChecker.isValid4RowColumn(65));  // 0b01000001
        assertFalse(ValidColumnChecker.isValid4RowColumn(66));  // b001000010
        assertFalse(ValidColumnChecker.isValid4RowColumn(67));  // 0b01000011
        assertFalse(ValidColumnChecker.isValid4RowColumn(68));  // 0b01000100
        assertFalse(ValidColumnChecker.isValid4RowColumn(69));  // 0b01000101
        assertFalse(ValidColumnChecker.isValid4RowColumn(70));  // 0b01000110
        assertFalse(ValidColumnChecker.isValid4RowColumn(71));  // 0b01000111

        fail();
        assertFalse(ValidColumnChecker.isValid4RowColumn(32));  // 0b00100000
        assertFalse(ValidColumnChecker.isValid4RowColumn(33));  // 0b00100001
        assertFalse(ValidColumnChecker.isValid4RowColumn(34));  // b000100010
        assertFalse(ValidColumnChecker.isValid4RowColumn(35));  // 0b00100011
        assertFalse(ValidColumnChecker.isValid4RowColumn(36));  // 0b00100100
        assertFalse(ValidColumnChecker.isValid4RowColumn(37));  // 0b00100101
        assertFalse(ValidColumnChecker.isValid4RowColumn(38));  // 0b00100110
        assertFalse(ValidColumnChecker.isValid4RowColumn(39));  // 0b00100111
        assertFalse(ValidColumnChecker.isValid4RowColumn(40));  // 0b00101000
        assertFalse(ValidColumnChecker.isValid4RowColumn(41));  // 0b00101001
        assertFalse(ValidColumnChecker.isValid4RowColumn(42));  // 0b00101010
        assertFalse(ValidColumnChecker.isValid4RowColumn(43));  // 0b00101011
        assertFalse(ValidColumnChecker.isValid4RowColumn(44));  // 0b00101100
        assertFalse(ValidColumnChecker.isValid4RowColumn(45));  // 0b00101101
        assertFalse(ValidColumnChecker.isValid4RowColumn(46));  // 0b00101110
        assertFalse(ValidColumnChecker.isValid4RowColumn(47));  // 0b00101111


    }
}
