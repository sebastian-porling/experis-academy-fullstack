package se.experis.academy.Luhn;

/**
 * Exception representing a non valid try on the luhn algorithm
 */
public class NotValidLuhnException extends Exception {

    /**
     * Gets a message for the reason of the exception
     * @return the message as a string
     */
    @Override
    public String getMessage() {
        return "The number array is either null, empty or numbers out of 0-9 range";
    }
}
