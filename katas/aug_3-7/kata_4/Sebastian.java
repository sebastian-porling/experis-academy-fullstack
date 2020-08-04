import java.util.*;
import java.util.stream.*;

/**
 * This application finds the prime factors of a given number
 * Either through argument or standard input
 */
public class Sebastian {

    /**
     * Main method
     * @param args One argument, numeric
     */
    public static void main(String[] args) {
        long number = getUserInput(args);
        printPrimeFactors(getPrimeFactors(number), number);
        System.out.println("\n#########################\n");
        printPrimeFactors(betterGetPrimeFactors(number), number);
    }

    /**
     * Prints out the user input and the prime factors
     * @param factors prime factors long list
     * @param number number
     */
    public static void printPrimeFactors(List<Long> factors, long number) {
        System.out.println("The prime factors for " + number + " are: ");
        factors.forEach(System.out::println);
    }

    /**
     * Gets the input from arguments or standard input
     * @param args first argument
     * @return long
     */
    public static long getUserInput(String... args) {
        Scanner scanner = args.length == 1 ? new Scanner(args[0]) : new Scanner(System.in);
        long number = 0;
        System.out.println("Enter the number you want prime facotrs for: ");
        try {
            number = scanner.nextInt();
        } catch (Exception e) {
            number = getUserInput(new String[0]);
        }
        scanner.close();
        return number;
    }

    /**
     * Finds all prime factors of given number and adds them as a list
     * @param n the number
     * @return a list of prime factors
     */
    public static List<Long> getPrimeFactors(long n) {
        List<Long> factors = new ArrayList<Long>();
        long i = 2;
        while(n != 1 && n != 0) {
            if (n % i == 0) {
                factors.add(i);
                n /= i;
                continue;
            }
            i++;
        }
        return factors;
    }

    /**
     * Finds all prime factors of given number and adds them as a list
     * @param n the number
     * @return
     */
    public static List<Long> betterGetPrimeFactors(long n) {
        return streamFactors(n).boxed().collect(Collectors.toList());
    }

    /**
     * Finds all prime factors of given number and adds them to a longstream
     * @param n the number
     * @return longstream with primefactors
     */
    private static LongStream streamFactors(long n) {
        return LongStream.range(2, n)
                .filter(i -> n % i == 0)
                .mapToObj(i -> LongStream.concat(LongStream.of(i), streamFactors(n / i)))
                .findFirst()
                .orElse(LongStream.of(n));
    }
}