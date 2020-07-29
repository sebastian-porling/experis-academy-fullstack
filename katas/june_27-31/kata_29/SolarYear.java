import java.util.Scanner;

public class SolarYear {

    /**
     * The main program that calculates a leap rule for a solar year
     */
    public static void main(String[] args) {
        String yearDuration = getSolarYearInput();

        if (yearDuration.contains(".")){
            String fractionParts[] = yearDuration.split("\\.");
            int decimal = 0;
            double solarYears = 0;

            /* Check if the number is valid */
            try {
                decimal = Integer.parseInt(fractionParts[0]);
                solarYears = Double.parseDouble(yearDuration);
            } catch (Exception e) {
                System.out.println("Not valid number/fraction, try again.");
                System.exit(0);
            }
            
            solarYears -= decimal;
            printLeapRule(solarYears);

        } else {
            System.out.println("No need for a leap year rule!");
            System.out.println("Or not a valid solar year!");
        }
    }

    /**
     * Prints out a leap year rule for a solar year
     * @param solarYears solar year
     */
    private static void printLeapRule(double solarYears) {
        String fraction = convertDecimalToFraction(solarYears);
        String fractionParts[] = fraction.split("/");
        System.out.println("(Year X " + fractionParts[0] + ") mod " + fractionParts[1] + " = R");
        System.out.println("R < " + fractionParts[0]);
    }

    /**
     * Calculates a fraction from a decimal
     * @param x a decimal
     * @return a fraction as a string
     */
    private static String convertDecimalToFraction(double x){
        if (x < 0){
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);
    
        return h1+"/"+k1;
    }

    /**
     * Gets the solar year from the user input
     * @return the solar year as a string
     */
    private static String getSolarYearInput(){
        String yearDuration = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the solar year fraction: ");
        yearDuration = scanner.nextLine();
        scanner.close();
        return yearDuration;
    }
}