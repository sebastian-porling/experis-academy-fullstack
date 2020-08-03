import java.util.Scanner;
import java.util.stream.Stream;

/**
 * This program takes in user input to calculate a fibonacci number.
 * It prints out the result from different methods of calculating a fibanacci number.
 */
public class FibonacciProgram {
    
    /**
     * The main program, 
     * Can either be used with the first argument as a numeric
     * or with a scanner from Standard input.
     * @param args
     */
    public static void main(String... args) {
        int num = getUserNumber(args);
        printFibonacci(num);
    }

    /**
     * Prints out the result from different fibonacci methods.
     * @param num
     */
    private static void printFibonacci(int num) {
        System.out.println("'Okey' fibonacci: ");
        System.out.println(Fibonacci.normalFibonacci(num));
        System.out.println("Fibonacci with streams: ");
        System.out.println(Fibonacci.otherFibonacci(num));
        System.out.println("Fibonacci with array: ");
        System.out.println(Fibonacci.arrayFibonacci(num));
        System.out.println("Slow simple recursive fibonacci: ");
        System.out.println(Fibonacci.simpleFibonacci(num));
    } 

    /**
     * Get the number the user wants to find in the fibonacci sequence
     * @param args first argument as a numeric
     * @return the fibonacci number user wants.
     */
    private static int getUserNumber(String... args) {
        Scanner scanner = args.length == 1 ? new Scanner(args[0]) : new Scanner(System.in);
        if (args.length != 0) {
            System.out.println("Enter the fibonacci number: ");
        }
        int num = 0;
        try {
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Not a valid number try again!");
            num = getUserNumber(new String[0]);
        }
        scanner.close();
        return num;
    }

    
}

/**
 * Class that has different methods of calculating a Fibonacci number
 */
class Fibonacci {
    private static long[] fibonacciNums;

    /**
     * Calculates fibonacci using a loop and sums the previous numbers.
     * @param n the fibonacci number searched
     * @return the fibonacci number
     */
    public static long normalFibonacci(int n) {
        long fibonacciNumber = 0;
        long n1 = 0;
        long n2 = 1;
        int i = 1;
        while (i < n) {
            long sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            fibonacciNumber = sum;
            i++;
        }
        return fibonacciNumber;
    }

    /**
     * A slow fibonacci method using recursion
     * @param n the fibonacci number searched
     * @return the fibonacci number
     */
    public static long simpleFibonacci(int n) {
        if(n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        if (n > 1) {
            return simpleFibonacci(n-1) + simpleFibonacci(n-2);
        }
        return 0;
    }

    /**
     * Initiates a array for the length of the fibonacci number,
     * and calculates the number using an array.
     * @param n the fibonacci number searched
     * @return the fibonacci number
     */
    public static long arrayFibonacci(int n) {
        fibonacciNums = new long[n+1];
        return calcArrayFibonacci(n);
    }

    /**
     * Calculates the fibonacci number using an array.
     * @param n the fibonacci number searched
     * @return the fibonacci number
     */
    private static long calcArrayFibonacci(int n) {
        if (fibonacciNums.length == 0) {
            return 0;
        }
        if(n == 0) {
            fibonacciNums[n] = 0;
            return 0;
        } else if (n == 1 || n == 2) {
            fibonacciNums[n] = 1;
            return 1;
        } else if (fibonacciNums[n] == 0) {
            return fibonacciNums[n] = (arrayFibonacci(n-1) + arrayFibonacci(n-2));
        }
        return fibonacciNums[n];
    }

    /**
     * Calculates the fibonacci using the streams api.
     * @param n the fibonacci number searched
     * @return the fibonacci number
     */
    public static long otherFibonacci(int n) {
        n++;
        long result = Stream.iterate(new long[]{0, 1}, i -> new long[]{i[1], i[0] + i[1]})
            .limit(n)
            .map(i -> i[0])
            .reduce((first, second) -> second).orElse(null);
        return result;
    }
}