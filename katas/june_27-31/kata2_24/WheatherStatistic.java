import java.util.ArrayList;
import java.util.Collections;

/**
 * This class can calculate different statistics of temperature readings.
 * like minimum, maximum and average temperatures in the population.
 */
public class WheatherStatistic {
    ArrayList<Integer> temperatures;

    /**
     * Constructor
     * @param temperatures a list of temperature readings.
     */
    public WheatherStatistic(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
    }

    /**
     * Returns the maximum temperature
     */
    public int getMaximumTemperature() {
        int maximum = Integer.MIN_VALUE;
        for (Integer temperature : temperatures) {
            if (temperature > maximum) {
                maximum = temperature;
            }
        }
        return maximum;
    }

    /**
     * Returns the minimum temperature
     */
    public int getMinimumTemperature() {
        int minimum = Integer.MAX_VALUE;
        for (Integer temperature : temperatures) {
            if (temperature < minimum) {
                minimum = temperature;
            }
        }
        return minimum;
    }

    /**
     * Returns the average temperature
     */
    public int getAverageTemperature() {
        int sum = 0;
        for (Integer temperature : temperatures) {
            sum += temperature;
        }
        int averageTemperature = sum / getTemperaturePopulation();
        return averageTemperature;
    }

    /**
     * Returns the size of the temperature population
     */
    public int getTemperaturePopulation() {
        return temperatures.size();
    }
}