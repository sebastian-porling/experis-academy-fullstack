package se.experis.academy;

/**
 * This class consists of some util methods
 */
public class Util {

    /**
     * Checks if the length is the same as a credit card
     * @param length Integer
     * @return True if 16
     */
    public static boolean validCreditCardLength(int length) {
        return length == 16;
    }
}
