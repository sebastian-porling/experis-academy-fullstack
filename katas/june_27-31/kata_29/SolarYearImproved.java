import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class calculates the needed leap years on a error tolerance on 1 * 10^6
 */
public class SolarYearImproved {
    private static ArrayList<String> leapYears = new ArrayList<String>();
    private static final double ERROR = 1.0E-6;

    /**
     * The main program
     * @param args ignores arguments.
     */
    public static void main(String[] args) {
        String solarDays = getUserInput();
        double solarDaysDecimal = parseStringToDouble(solarDays);
        findLeapYears(solarDaysDecimal);
        printLeapYears();
    }

    /**
     * Finds the leap years needed on a error tolerance on 1 * 10^6
     * @param solarDaysDecimal The solar days
     */
    private static void findLeapYears(double solarDaysDecimal) {
        while (solarDaysDecimal > ERROR) {
            double closestDivisor = findClosestDivisor(solarDaysDecimal);
            double closestFraction = 1 / closestDivisor;
            String divisor = closestDivisor + "";
            logLeapYear(divisor);
            solarDaysDecimal = abs(solarDaysDecimal - closestFraction);
        }
    }

    /**
     * Prints out all the leap years from arraylist
     */
    private static void printLeapYears() {
        if (leapYears.size() != 0) {
            System.out.print("Skip a day every ");
            for (int i = 0; i < leapYears.size(); i++) {
                System.out.print(leapYears.get(i));
                if (leapYears.size() > 1 && i == 0) {
                    System.out.print(" and ");
                } else if (i != leapYears.size()-1) {
                    System.out.print(", ");
                }
            }
            System.out.print(" years.\n");
        } else {
            System.out.println("No leap years needed!");
        }
    }

    /**
     * The absolute value of a double
     * @param decimal double to take absolute value of.
     * @return positive double
     */
    private static double abs(double decimal) {
        if (decimal < 0) {
            decimal *= -1;
        }
        return decimal;
    }

    /**
     * Parses a string of solar days to a double, but removes the days before the decimal.
     * @param text solar days
     * @return solar days decimal point numbers.
     */
    private static double parseStringToDouble(String text) {
        double parsedDecimal = 0;
        try {
            parsedDecimal = Double.parseDouble("0." + text.split("\\.")[1]);
        } catch (Exception e) {
            System.out.println(text + " is not a valid decimal number!");
            System.exit(0);
        }
        return parsedDecimal;
    }

    /**
     * Finds the closest divisor for 
     * @param DECIMAL
     * @return
     */
    private static double findClosestDivisor(final double DECIMAL) {
        double divisor = 1;
        double oldDivisor = 1;
        
        while ((DECIMAL - (1 / divisor)) < 0) {
            oldDivisor = divisor;
            divisor++;
        }

        if (abs(DECIMAL - (1 / divisor)) < abs(DECIMAL - (1 / oldDivisor))) {
            return divisor;
        }
        return oldDivisor;
    }

    /**
     * Takes in the user input with scanner
     * @return user input as a string
     */
    private static String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a solar year rational number: ");
        String solarDays = scanner.nextLine();
        scanner.close();
        return solarDays;
    }

    /**
     * Adds the leap year to the arraylist
     * @param LEAP_YEAR leap year to add.
     */
    private static void logLeapYear(final String LEAP_YEAR){
        leapYears.add(LEAP_YEAR);
    }
}