
/**
     * A program that prints the numbers from 1 to 100. 
     * But for multiples of three print “Fizz” instead 
     * of the number and for the multiples of five print “Buzz”. 
     * For numbers which are multiples of both three and five print 
     * “FizzBuzz “.
     */
public class FizzBuzz {

    /* Main program, arguments are ignored */
    public static void main(String[] args) {
        String output;

        for (int i = 0; i <= 100; i++) {
            
            /* Check if the number is divisible by three and five */
            if (isDivisibleByFive(i) && isDivisibleByThree(i)) {
                output = "FizzBuzz";
            } else if (isDivisibleByFive(i)) {
                output = "Buzz";
            } else if (isDivisibleByThree(i)) {
                output = "Fizz";
            } else {
                output = "" + i;
            }
            
            /* Print with seperator if not the last number */
            if (i != 100) {
                System.out.print(output + ", ");
            } else {
                System.out.print(output);
            }
            
            /* If divisible by ten, print new line */
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
    
    /**
     * Checks if number is divisible by five
     * @param number integer to check
     * @return true if divisble by five, false otherwise
     */
    private static boolean isDivisibleByFive(int number) {
        return (number % 5 == 0);
    }

    /**
     * Checks if number is divisible by five
     * @param number integer to check
     * @return true if divisble by five, false otherwise
     */
    private static boolean isDivisibleByThree(int number) {
        return (number % 3 == 0);
    }
}