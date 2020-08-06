import java.util.*;

/**
 * A class that takes two numbers, prints their values and swaps them.
 */
public class Sebastian {
    private static Scanner scanner;

    /**
     * Main method
     * @param args ignored
     */
    public static void main(String... args) {
        TwoNumbers twoNumbers = getUserInput();
        printNumbers(twoNumbers);
        System.out.println("\nSwapped\n");
        twoNumbers.swapNumbersRandomMethod();;
        printNumbers(twoNumbers);
    }

    /**
     * Prints out the two numbers
     * @param twoNumbers
     */
    public static void printNumbers(TwoNumbers twoNumbers) {
        System.out.println(twoNumbers);
    }

    /**
     * Gets two numbers from the user
     * @return two numbers
     */
    public static TwoNumbers getUserInput() {
        scanner = new Scanner(System.in);
        int[] numbers = new int[2];
        System.out.println("Enter two numbers seperated by 'enter': ");
        for (int i = 0; i < numbers.length; i++) {
            try {
                numbers[i] = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
            }
        }
        TwoNumbers twoNumbers;
        try {
            twoNumbers = new TwoNumbers(numbers[0], numbers[1]);
        } catch (Exception e) {;
            System.out.println("One or both are not a number...");
            twoNumbers = getUserInput();
        }
        return twoNumbers;
    }
}

/**
 * Class representing two numbers
 * and can swap their values
 */
class TwoNumbers{
    private int first;
    private int second;

    /**
     * Constructor
     */
    public TwoNumbers(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Swaps the numbers using
     * one out of three methods
     */
    public void swapNumbersRandomMethod() {
        Random random = new Random();
        int method = random.nextInt(3);
        switch(method) {
            case 1:
                swapNumbersAddSub();
                break;
            case 2:
                swapNumbersMulDiv();
                break;
            case 3:
                swapNumbersXor();
                break;
            default:
                swapNumbersRandomMethod();
        }
    }

    public void swapNumbersAddSub(){
        first = first + second;
        second = first - second;
        first = first - second;
    }

    public void swapNumbersMulDiv() {
        first = first * second;
        second = first / second;
        first = first / second;
    }

    public void swapNumbersXor() {
        first = first ^ second;
        second = first ^ second;
        first = first ^ second;
    }

    @Override
    public String toString() {
        return "First number: " + first + ", second number: " + second;
    }
}