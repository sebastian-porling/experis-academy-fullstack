package characters.stats;

/**
 * This class generates weighted stats
 */
public class StatGenerator {

    /**
     * Generates stats that are weighted.
     * @param weightedStat The way the stats should be weighted towards, thoughness, speed, intelligence...
     * @return Stats object
     */
    public static Stats generate(StatType weightedStat) {
        Stats stats = new Stats();
        boolean correctWeighted = false;
        while(!correctWeighted) {
            stats = new Stats();
            switch (weightedStat) {
                case THOUGHNESS:
                    if (highThoughness(stats)) {
                        correctWeighted = true;
                    }
                break;
                case INTELLIGENCE:
                    if (highIntelligence(stats)){
                        correctWeighted = true;
                    }
                break;
                case SPEED:
                    if (highSpeed(stats)){
                        correctWeighted = true;
                    }
                break;
                default:
                    correctWeighted = true;
            }
        }
        return stats;
    } 

    /**
     * Checks if speed is the highest stat
     * @param stats the stats
     * @return true of speed is highest.
     */
    private static boolean highSpeed(Stats stats) {
        return stats.getSpeed() > stats.getThoughness() && stats.getSpeed() > stats.getIntelligence();
    }

    /**
     * Checks if intelligence is the highest stat
     * @param stats the stats
     * @return true if intelligence is the highest
     */
    private static boolean highIntelligence(Stats stats) {
        return stats.getIntelligence() > stats.getThoughness() && stats.getIntelligence() > stats.getSpeed();
    }

    /**
     * Checks if thoughness is the highest stat
     * @param stats the stats
     * @return true if thoughness is the highest
     */
    private static boolean highThoughness(Stats stats) {
        return stats.getThoughness() > stats.getIntelligence() && stats.getThoughness() > stats.getSpeed();
    }
}