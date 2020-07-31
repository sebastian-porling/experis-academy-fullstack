package se.experis.academy.Luhn;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * This class can calculate the checksum for an int array using luhn algorithm
 */
public class LuhnAlgorithm {

    /**
     * Checks if the control number is correct
     * @param numbers array of numbers in the range of (0-9)
     * @return True if the control number is valid
     * @throws NotValidLuhnException if out of range, empty or null.
     */
    public boolean validChecksum(Integer[] numbers) throws NotValidLuhnException {
        return controlNumber(numbers) == numbers[numbers.length-1];
    }

    /**
     * Calculates the control number of the given array
     * @param numbers int array where each int is in the range of 0-9
     * @return control number
     * @throws NotValidLuhnException if out of range, empty or null.
     */
    public int controlNumber(Integer[] numbers) throws NotValidLuhnException{
        checkNumberArray(numbers);
        Integer sum = IntStream.range(0, numbers.length-1)
                .map(i -> evenLuhn(i, numbers.length) ? calcTimesTwo(numbers[i]) : numbers[i])
                .reduce(0, Integer::sum);
        return sum * 9 % 10;
    }

    /**
     * Helper function for calculating the numbers required to be
     * multiplied with two, which then have to be "splitted" when
     * larger than 9.
     * @param num Integer
     * @return Integer
     */
    private int calcTimesTwo(int num){
        return ((2 * num) / 10) + ((2 * num) % 10);
    }

    /**
     * Helper function that hecks if the current iteration of the
     * number length should be multiplied with times to or not.
     * @param iteration current iteration
     * @param length length of the number
     * @return true if even length and even iteration, true if odd length and odd iteration.
     */
    private boolean evenLuhn(int iteration, int length) {
        return ((iteration % 2) ^ (length % 2)) == 0;
    }

    /**
     * Checks of the array is valid
     * @param numbers array of numbers
     * @throws NotValidLuhnException if out of range, empty or null.
     */
    public void checkNumberArray(Integer[] numbers) throws NotValidLuhnException{
        if (numbers == null || numbers.length == 0) {
            throw new NotValidLuhnException();
        }
        if (Arrays.stream(numbers).anyMatch(n -> n < 0 || n > 9)) {
            throw new NotValidLuhnException();
        }
    }
}
