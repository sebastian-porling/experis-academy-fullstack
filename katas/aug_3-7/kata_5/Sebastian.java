
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * This class gets or generates numbers into a collection
 * And prompts the user to enter a number to search for in the collection.
 */
public class Sebastian {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The main program, ignores arguments, 
     * but can take in numbers from standard in through console or pipe
     * @param args ignored
     */
    public static void main(String[] args) {
        Set<Integer> numbers = getUserNumbers();
        Integer number = getSearchedNumber();
        boolean numberExists = numberExistsInList(number, numbers);
        printResult(numberExists, number);
        scanner.close();
    }

    /**
     * Prints out a message if the number exists or not
     * @param numberExists if the number exists
     * @param number the number
     */
    public static void printResult(boolean numberExists, Integer number) {
        String output = "\n" + number + (numberExists ? " Exists " : " Doesn't exist ") + "in the collection.";
        System.out.println(output);
    }

    /**
     * Checks if the number exists in the collection
     * @param number searched integer
     * @param numbers collection of integers
     * @return true if it exists in the collection
     */
    public static boolean numberExistsInList(Integer number, Set<Integer> numbers) {
        return numbers.contains(number);
    }

    /**
     * Promts the user to enter a number to look for in the collection 
     * of integers and returns it.
     * @return the searched integer
     */
    public static Integer getSearchedNumber() {
        Integer number = 0;
        System.out.println("What number are you looking for?: ");
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Not a number! Try again!");
            number = getSearchedNumber();
        }
        return number;
    }

    /**
     * Gets a numbers from user till we get a empty line.
     * If their is no user input we generate random integers instead.
     * @return set of integers
     */
    public static Set<Integer> getUserNumbers() {
        Set<Integer> numbers = new HashSet<Integer>();
        while(scanner.hasNextLine()) {
            try {
                String input = scanner.nextLine();
                if (input.length() == 0) {
                    break;
                } else {
                    numbers.add(Integer.parseInt(input));
                }
            } catch (Exception e) {
                /* Non numeric found */
            }
        }
        if (numbers.size() == 0) {
            numbers = generateNumbers();
        }
        return numbers;
    }

    /**
     * Generates 10^4 random integers from 0 to 10^5
     * @return set of random integers
     */
    public static Set<Integer> generateNumbers() {
        Set<Integer> numbers = new HashSet<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1_00_000; i++) {
            numbers.add(random.nextInt(1_000_000));
        }
        return numbers;
    }
}