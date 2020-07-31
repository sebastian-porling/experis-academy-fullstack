package se.experis.academy;

import org.junit.jupiter.api.Test;
import se.experis.academy.Luhn.LuhnAlgorithm;
import se.experis.academy.Luhn.NotValidLuhnException;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {
    private final LuhnAlgorithm luhn = new LuhnAlgorithm();

    @Test
    void validChecksumIsTrue() {
        Integer[] numbers1 = {4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2};
        Integer[] numbers2 = {5, 1, 2, 3, 5, 1, 6, 2, 3, 1, 5, 6, 1, 8};
        Integer[] numbers3 = {8, 1, 1, 2, 1, 8, 9, 8, 7, 6};
        Integer[] numbers4 = {5, 8, 9, 4, 2, 8, 2};
        try{
            assertTrue(luhn.validChecksum(numbers1));
            assertTrue(luhn.validChecksum(numbers2));
            assertTrue(luhn.validChecksum(numbers3));
            assertTrue(luhn.validChecksum(numbers4));

        }catch (NotValidLuhnException e) {
            fail("Threw exception");
        }
    }

    @Test
    void validChecksumIsFalse() {
        Integer[] numbers1 = {4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 1};
        Integer[] numbers2 = {5, 1, 2, 3, 5, 1, 6, 2, 3, 1, 5, 6, 1, 2};
        Integer[] numbers3 = {8, 1, 1, 2, 1, 8, 9, 8, 7, 2};
        try{
            assertFalse(luhn.validChecksum(numbers1));
            assertFalse(luhn.validChecksum(numbers2));
            assertFalse(luhn.validChecksum(numbers3));
        }catch (NotValidLuhnException e) {
            fail("Threw exception");
        }
    }

    @Test
    void validChecksumHandlesNull() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.validChecksum(null));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void validChecksumHandlesEmptyArray() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.validChecksum(null));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void controlNumberReturnsCorrectChecksum() {
        Integer[] numbers1 = {4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2, 4, 2};
        Integer[] numbers2 = {5, 1, 2, 3, 5, 1, 6, 2, 3, 1, 5, 6, 1, 8};
        Integer[] numbers3 = {1, 2, 3, 0};
        try{
            assertEquals(2, luhn.controlNumber(numbers1));
            assertEquals(8, luhn.controlNumber(numbers2));
            assertEquals(0, luhn.controlNumber(numbers3));
        }catch (NotValidLuhnException e) {
            fail("Threw exception");
        }
    }

    @Test
    void controlNumberHandlesNull() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.controlNumber(null));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void controNumberHandlesEmptyArray() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.controlNumber(null));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void checkNumberArrayChecksNull() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.checkNumberArray(null));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void checkNumberArrayChecksEmptyArray() {
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.checkNumberArray(new Integer[0]));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }

    @Test
    void checkNumberArrayChecksNumbersWithinRange() {
        Integer[] numbers = {10, -1, Integer.MAX_VALUE, Integer.MIN_VALUE};
        Throwable exception = assertThrows(NotValidLuhnException.class, () -> luhn.checkNumberArray(numbers));
        assertEquals("The number array is either null, empty or numbers out of 0-9 range", exception.getMessage());
    }
}