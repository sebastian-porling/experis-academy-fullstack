package se.experis.academy;

import se.experis.academy.Luhn.LuhnAlgorithm;
import se.experis.academy.Luhn.NotValidLuhnException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This program can validate any sequence of numbers if they have a valid checksum
 * Using the Luhn Algorithm
 */
public class Main {
    private static final LuhnAlgorithm LUHN = new LuhnAlgorithm();

    /**
     * The main method
     * @param args The number you want to check
     */
    public static void main(String... args) {
	    Integer[] numbers = getUserInput(args);
	    int providedChecksum = 0;
	    boolean validCreditCard = Util.validCreditCardLength(numbers.length);
        int calculatedChecksum = 0;
        boolean validChecksum = false;
	    try {
            calculatedChecksum = LUHN.controlNumber(numbers);
            validChecksum = LUHN.validChecksum(numbers);
            providedChecksum = numbers[numbers.length-1];
        } catch (NotValidLuhnException e){
            System.out.println(e.getMessage());
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("The number is not valid");
	        System.exit(0);
        }
	    print(numbers, providedChecksum, calculatedChecksum, validCreditCard, validChecksum);
    }

    /**
     * Prints out the result and if the number is a credit card
     * @param numbers number array
     * @param providedChecksum The checksum from the number array
     * @param calculatedChecksum The calculated checksum
     * @param validCreditCard If it is a valid credit card
     * @param validChecksum If the checksum is valid
     */
    public static void print(Integer[] numbers, int providedChecksum, int calculatedChecksum, boolean validCreditCard, boolean validChecksum) {
        System.out.print("\nInput: ");
        Arrays.stream(numbers).forEach(System.out::print);
        System.out.println();
        System.out.println("Provided checksum: " + providedChecksum);
        System.out.println("Expected checksum: " + calculatedChecksum);
        System.out.println();
        String checksumValidity = validChecksum ? "Valid" : "Not valid";
        System.out.println("Checksum: " + checksumValidity);
        String isCreditCard = validCreditCard ? " (credit card)" : " (not a creditcard)";
        System.out.println("Digits: " + numbers.length + isCreditCard);
    }

    /**
     * Gets user input using either arguments from running the program
     * or from scanner
     * @param args number sequence
     * @return the number sequence as a int array
     */
    public static Integer[] getUserInput(String... args) {
        Scanner scanner = args != null && args.length == 1 ? new Scanner(args[0]) : new Scanner(System.in);
        String text = getInput(scanner);
        List<String> filtered = Arrays.stream(text.split(""))
                .map(n -> n.replaceAll("[^0-9]", ""))
                .filter(candidate -> candidate.matches("[0-9]"))
                .collect(Collectors.toList());
        return filtered.stream().map(Integer::valueOf).toArray(Integer[]::new);
    }

    /**
     * Gets the input from scanner
     * @param scanner the input stream
     * @return user input
     */
    private static String getInput(Scanner scanner) {
        String text;
        try (scanner) {
            System.out.println("Enter the number sequence: ");
            text = scanner.nextLine();
        } catch (Exception e) {
            text = "";
        }
        return text;
    }
}
