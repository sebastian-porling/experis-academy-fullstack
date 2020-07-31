import java.util.Scanner;

/**
 * This class represents ceaser cipher and decipher!
 */
public class Ceasar {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main program, takes in whether the user wants to
     * cipher or decipher and then takes in the text and amount of steps.
     * @param args
     */
    public static void main(String[] args) {
        Choice choice = getUserChoice();
        UserInput userInput = getUserInput();
        String result = getResult(userInput, choice);
        System.out.println("Resulting in the text: " + result);
        scanner.close();
    }

    /**
     * Based on the choice of cipher or decipher we get the resulting text
     * after that operation.
     * @param userInput object consisting of the text and amount of steps
     * @param choice the choice of cipher of decipher
     * @return resulting text
     */
    public static String getResult(UserInput userInput, Choice choice) {
        String result = "";
        switch (choice) {
            case CIPHER:
                result = cipher(userInput.steps, userInput.text);
                break;
            case DECIPHER:
                result = decipher(userInput.steps, userInput.text);
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * Gets the user choice of decipher or cipher
     * @return
     */
    public static Choice getUserChoice() {
        Choice choice = null;
        System.out.println("Do you want to cipher or decipher?: ");
        String text = scanner.nextLine();
        if (text.toLowerCase().matches("cipher")) {
            choice = Choice.CIPHER;
        } else if (text.toLowerCase().matches("decipher")) {
            choice = Choice.DECIPHER;
        } else {
            System.out.println("Not valid option, try again...");
            choice = getUserChoice();
        }
        return choice;
    }

    /**
     * Gets the text and amount of steps
     * @return object consisting of text and amount of steps
     */
    public static UserInput getUserInput() {
        System.out.println("Enter string to cipher/decipher: ");
        String text = scanner.nextLine().replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println("Enter amount of steps to cipher/decipher: ");
        int steps = 0;
        try {
            steps = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Not a valid number, try again...");
            System.exit(0);
        }
        return new UserInput(text, steps);
    }

    /**
     * Ciphers the text up the alphabet with the amount of steps
     * @param steps Integer
     * @param text String
     * @return resulting cipher
     */
    public static String cipher(int steps, String text) {
        char[] result = text.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] + steps > 122) {
                result[i] = (char) (result[i] + steps - 26);
            } else {
                result[i] = (char) (result[i] + steps);
            }
        }
        return new String(result);
    }

    /**
     * Deciphers the text down the amount of steps provided
     * @param steps Integer
     * @param text String
     * @return deciphered text
     */
    public static String decipher(int steps, String text) {
        char[] result = text.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] - steps < 97) {
                result[i] = (char) (result[i] - steps + 26);
            } else {
                result[i] = (char) (result[i] - steps);
            }
        }
        return new String(result);
    }
}

/**
 * Representing the choice of cipher or decipher
 */
enum Choice {
    CIPHER,
    DECIPHER
}

/**
 * Represents the user input for Ceasar cipher
 */
class UserInput {
    final String text;
    final int steps;

    /**
     * Constructor
     * @param text String
     * @param steps Integer
     */
    public UserInput(String text, int steps) {
        this.text = text;
        this.steps = steps;
    }
}