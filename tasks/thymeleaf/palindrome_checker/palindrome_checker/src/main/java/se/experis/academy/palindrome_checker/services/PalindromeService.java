package se.experis.academy.palindrome_checker.services;

import org.springframework.stereotype.Service;
import se.experis.academy.palindrome_checker.models.Palindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Handles all business logic for finding palindromes
 */
@Service("PalindromeService")
public class PalindromeService {

    /**
     * Gets the palindrome in the String provided.
     * @param candidates String with multiple palindrome candidates separated with space
     * @return palindrome
     */
    public List<Palindrome> getPalindromes(String candidates) {
        List<Palindrome> palindromes = new ArrayList<>();
        for (String candidate: candidates.split("[ \n]")) {
            if (candidate.isBlank()) continue;
            palindromes.add(getPalindrome(candidate));
        }
        return palindromes;
    }

    /**
     * Gets a palindrome or blank if not a palindrome
     * @param candidate string
     * @return palindrome or blank
     */
    public Palindrome getPalindrome(String candidate) {
        String palindromeString = checkPalindrome(candidate);
        return !palindromeString.isBlank() ?
                new Palindrome(candidate, true, palindromeString) :
                new Palindrome(candidate, false, "");
    }

    /**
     * Gets the palindrome in the String provided.
     * @param candidate String with a word
     * @return Longest palindrome
     */
    private String checkPalindrome(String candidate) {
        if (!validStringCandidate(candidate)){
            return "";
        }

        String longestCandidate = candidate.substring(0, 1);
        final String CANDIDATE_CHECKER = longestCandidate;

        for (int i = 0; i < candidate.length(); i++) {
            String evenPalindrome = evenPalindrome(candidate, i, i);
            longestCandidate = checkCandidate(evenPalindrome, longestCandidate);

            String oddPalindrome = oddPalindrome(candidate, i, i);
            longestCandidate = checkCandidate(oddPalindrome, longestCandidate);
        }

        if (Objects.equals(longestCandidate, CANDIDATE_CHECKER)) {
            return "";
        }
        return longestCandidate;
    }

    /**
     * Checks if the string is valid for a palindrome check.
     */
    private boolean validStringCandidate(String candidate) {
        return (candidate != null) && !candidate.equals("") && !(candidate.length() <= 1);
    }

    /**
     * Finds a palindrome of an even string
     * @param candidate String with word
     * @param start Where to start the check
     * @param end Where to end the check
     * @return A palindrome
     */
    private String evenPalindrome(String candidate, int start, int end) {
        return findPalindrome(candidate, start, end);
    }

    /**
     * Find a palindrome of an odd string
     * @param candidate String with a word
     * @param start Where to start the check
     * @param end Where to end the check
     * @return A palindrome
     */
    private String oddPalindrome(String candidate, int start, int end) {
        return findPalindrome(candidate, start, end + 1);
    }

    /**
     * Finds a palindrome of a string
     * @param candidate String with a word
     * @param start Where to start the search
     * @param end Where to end the search
     * @return A palindrome
     */
    private String findPalindrome (String candidate, int start, int end) {
        while(withinBounds(candidate, start, end) && sameCharAtTwoIndex(candidate, start, end)){
            start--;
            end++;
        }
        return candidate.substring(start + 1, end);
    }

    /**
     * Checks if the start and end is within bounds of the candidate string
     * @param candidate String of a word
     * @param start starting index.
     * @param end ending index.
     * @return True if within bounds, false otherwise.
     */
    private boolean withinBounds(String candidate, int start, int end) {
        return start >= 0 && end <= candidate.length() - 1;
    }

    /**
     * @param candidate String of a word
     * @param start starting index
     * @param end ending index
     * @return True if the chars at both index are equal.
     */
    private boolean sameCharAtTwoIndex(String candidate, int start, int end) {
        return candidate.charAt(start) == candidate.charAt(end);
    }

    /**
     * Returns the palindrome candidate that is the longest
     * @param newCandidate string
     * @param oldCandidate string
     * @return The candidate that is the longest.
     */
    private String checkCandidate(String newCandidate, String oldCandidate) {
        return newCandidate.length() > oldCandidate.length() ? newCandidate : oldCandidate;
    }
}