package se.experis.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void checkValidCreditCardLength() {
        assertFalse(Util.validCreditCardLength(15));
        assertTrue(Util.validCreditCardLength(16));
        assertFalse(Util.validCreditCardLength(17));
        assertFalse(Util.validCreditCardLength(Integer.MIN_VALUE));
        assertFalse(Util.validCreditCardLength(Integer.MAX_VALUE));
        assertFalse(Util.validCreditCardLength(0));
    }
}