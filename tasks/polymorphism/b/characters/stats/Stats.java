package characters.stats;

import java.util.Random;

/**
 * A class that represents the stats of intelligence, thoughness and speed.
 */
public class Stats {
    private int intelligence;
    private int thoughness;
    private int speed;

    /**
     * Constructor that generates random stats.
     */
    public Stats () {
        randomStats();
        while(!validStats()) {
            randomStats();
        }
    }

    /**
     * Generates random stats between 0-10
     */
    private void randomStats() {
        Random random = new Random();
        this.intelligence = random.nextInt(10);
        this.thoughness = random.nextInt(10);
        this.speed = random.nextInt(10);
    }

    /**
     * Checks so the sum of the stats are between 15 and 20
     * @return true if between 15 and 20
     */
    private boolean validStats() {
        int totalStats = this.intelligence + this.thoughness + this.speed;
        return (totalStats >= 15) && (totalStats <= 20);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getThoughness() {
        return thoughness;
    }
    
}