import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class takes in readings from standard input.
 * Just pipe a file with temperature readings and then
 * you will get the minimum, maximum. average and number of readings.
 */
public class WheaterStation {

    /**
     * Main program that takes in readings fropm StdIn.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> readings = new ArrayList<>();
        WheatherStatistic wheatherStatistic;

        /* Reads from standard input and adds them to the list */
        while (scanner.hasNext()) {
            int reading = scanner.nextInt();
            readings.add(reading);
        }
        wheatherStatistic = new WheatherStatistic(readings);

        /* Prints out the min, max, average and size of population to console. */
        System.out.println("Minimum temperature is: " + wheatherStatistic.getMinimumTemperature());
        System.out.println("Maximum temperature is: " + wheatherStatistic.getMaximumTemperature());
        System.out.println("Average temperatur is: " + wheatherStatistic.getAverageTemperature());
        System.out.println("Number of temperature readings is: " + wheatherStatistic.getTemperaturePopulation());
    }
}