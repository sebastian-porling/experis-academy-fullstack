
/**
 * A calculate that can return the product or sum of numbers in a single string.
 * java Calculator <string with numbers seperated with ','> <add or multiply>
 * ex. java Calculator "1,5,6.123" add
 */
public class Calculator {
    private static final String NON_NUMERICALS = "[^0-9.]";

    /**
     * The main program, checks the arguments, parses the string and uses the given operator.
     */
    public static void main(String[] args) {
        checkArguments(args);

        String[] numbers = args[0].split(",");
        int[] parsedNumbers = parseStringToNumbers(numbers);
        String operator = args[1].toLowerCase();
        
        String result;
        switch (operator) {
            case "add":
                result = add(parsedNumbers);
                System.out.println("The sum is: " + result);
                break;
            case "multiply":
                result = multiply(parsedNumbers);
                System.out.println("The product is: " + result);
                break;
            default:
                System.out.println("The operator is not supported.");
        }   
    }

    /**
     * Checks so the number of arguments are two
     * @param args The array of arguments.
     */
    private static void checkArguments(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong use of program, use: java Calculator <string> <add or multiply>");
            System.exit(0);
        }
    }

    /**
     * Parses a string to a float or integer, but casts it to a rounded integer.
     * If a character wouldn't be a numerical, then it is ignored.
     * @param numbers Array of potential numbers
     * @return Array of numbers
     */
    private static int[] parseStringToNumbers(String[] numbers) {
        int[] parsedNumbers = new int[numbers.length];
        boolean formatingError = false;
        for (int i = 0; i < numbers.length; i++) {
            String candidate = numbers[i].replaceAll(NON_NUMERICALS, "");
            try {
                if (numbers[i].contains(".")) {
                     parsedNumbers[i] = Math.round(Float.parseFloat(candidate));
                } else {
                    parsedNumbers[i] = Integer.parseInt(candidate);
                }
                System.out.println(parsedNumbers[i]);
            } catch (Exception e) {
                formatingError = true;
            } 
        }
        if (formatingError) {
            System.out.println("You've entered other than numericals or to large numbers.");
            System.out.println("The calculation might not be correct.");
        }
        return parsedNumbers;
    }

    /**
     * Calculates the sum of given numbers
     * @param numbers The numbers to sum
     * @return The sum
     */
    private static String add(int[] numbers){
        int sum = 0;
        for (int term : numbers) {
            sum += term;
        }
        return sum + "";
    }

    /**
     * Calculated the product of given numbers
     * @param numbers The numbers to product
     * @return The product
     */
    private static String multiply(int[] numbers) {
        int product = 1;
        for (int term : numbers) {
            if (term == 0) {
                continue;
            }
            product *= term;
        }
        return product + "";
    }
}