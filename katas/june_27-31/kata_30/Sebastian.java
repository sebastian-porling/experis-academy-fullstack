import java.util.Scanner;

/**
 * This class prints out the longest common sequence of characters
 * shared between two words.
 * @author Sebastian Porling
 */
public class Sebastian {

    /**
     * The main program, two strings in argument or none.
     * @param args Two strings 
     */
    public static void main(String[] args) {
        TwoStrings userInput = getTwoStrings(args);
        String longestCommonSequence = userInput.getLongestCommonSequence();
        printResult(userInput, longestCommonSequence);
    }

    /**
     * Prints the resulting longest common char sequence
     * proviced from the user.
     * @param input the two strings object
     * @param result the longest common char sequence
     */
    private static void printResult(TwoStrings input, String result) {
        System.out.println(
            "The longest char sequence for: " + 
            input.getFirst() + " and " + input.getSecond() + 
            " is: " + result);
    }

    /**
     * Gets the user input from argument or scanner into a object
     * @param args Two Strings or none
     * @return a object with two strings
     */
    private static TwoStrings getTwoStrings(String... args){
        TwoStrings userInput = null;
        if(args.length != 0) {
            userInput = getUserInput(args);
        } else {
            userInput = getUserInput();
        }
        return userInput;
    }

    /**
     * Gets the user input, two strings seperated with a comma.
     * Which is then put into a TwoStrings object.
     * @return a object with two strings
     */
    private static TwoStrings getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two strings seperated with a ',': ");
        String userInput = scanner.nextLine();
        String[] splittedInput = userInput.split(",");
        if (splittedInput.length!= 2) {
            System.out.println("The strings are not seperated with a comma or you have used to many commas!");
            System.exit(0);
        }
        TwoStrings input = new TwoStrings(splittedInput[0], splittedInput[1]);
        scanner.close();
        return input;
    }

    /**
     * Processes the arguments and puts them into a object if valid.
     * @param args two strings
     * @return an object with two strings
     */
    private static TwoStrings getUserInput(String... args){
        if (args.length != 2) {
            System.out.println("Wrong use of arguments, use: java Sebastian <String> <String>");
            System.exit(0);
        }
        TwoStrings userInput = new TwoStrings(args[0], args[1]);
        return userInput;
    }
}

/**
 * This class represents two strings
 * And can calculate the longest common char sequence
 */
class TwoStrings {
    private final String first;
    private final String second;

    /**
     * Constructor
     * @param first a string
     * @param second a string
     */
    public TwoStrings(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    /**
     * Finds the longest common char sequence
     * @return the longest common char sequence of the two strings
     */
    public String getLongestCommonSequence() {
        int longest = 0;
        String longestSequence = "";

        for (int i = 0; i < first.length(); i++) {
            for (int j = i+1; j <= first.length(); j++) {
                String sequenceCandidate = first.substring(i, j);
                if (second.contains(sequenceCandidate) && sequenceCandidate.length() > longest) {
                    longest = sequenceCandidate.length();
                    longestSequence = sequenceCandidate;
                }
            }
        }
        return longestSequence;
    }
}