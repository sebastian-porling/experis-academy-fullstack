package se.experis.academy.palindrome_checker.models;

/**
 * Represents a object having the original text
 * a variable if it is a palindrome
 * and the palindrome text
 */
public class Palindrome {
    private final String text;
    private final boolean isPalindrome;
    private final String palindrome;

    /**
     * Constructor
     * @param text original text
     * @param isPalindrome is it a palendrome
     * @param palindrome the palendrome or blank
     */
    public Palindrome(String text, boolean isPalindrome, String palindrome) {
        this.text = text;
        this.isPalindrome = isPalindrome;
        this.palindrome = palindrome;
    }

    public String getText() {
        return text;
    }

    public String getPalindrome() {
        return palindrome;
    }

    public boolean getIsPalindrome() {
        return isPalindrome;
    }
}
