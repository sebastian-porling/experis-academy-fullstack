

public class Palindrome {
    
    /**
     * Main program, takes in one String that is checked for palindrome
     * @param args Takes one argument, a string.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Use: Palindrome <word>");
        }

        Palindrome palindrome = new Palindrome();
        String candidate = args[0];
        String output = palindrome.getPalindrome(candidate);

        System.out.println("Input: " + candidate);
        System.out.println("Output: " + output);
    }

    /**
     * Gets the palindrome in the String provided.
     * @param candidate String with a word
     * @return Longest palindrome
     */
    public String getPalindrome(String candidate) {
        if (!validStringCandidate(candidate)){
            return candidate;
        }

        String longestCandidate = candidate.substring(0, 1);
        final String CANDIDATE_CHECKER = longestCandidate;

        for (int i = 0; i < candidate.length(); i++) {
            String evenPalindrome = evenPalindrome(candidate, i, i);
            longestCandidate = checkCandidate(evenPalindrome, longestCandidate);

            String oddPalindrome = oddPalindrome(candidate, i, i);
            longestCandidate = checkCandidate(oddPalindrome, longestCandidate);
        }

        if (longestCandidate == CANDIDATE_CHECKER) {
            return "No palindrome found";
        }

        return longestCandidate;
    }

    /**
     * Checks if the string is valid for a palindrome check.
     */
    private boolean validStringCandidate(String candidate) {
        return (candidate != null) && (candidate != "") && !(candidate.length() <= 1);
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
     * Returns the palindrum candidate that is the longest
     * @param newCandidate
     * @param oldCandidate
     * @return The candidate that is the longest.
     */
    private String checkCandidate(String newCandidate, String oldCandidate) {
        return newCandidate.length() > oldCandidate.length() ? newCandidate : oldCandidate;
    }
}