package characters;

import characters.stats.StatGenerator;
import characters.stats.StatType;
import characters.stats.Stats;

/**
 * This class represents a Ranger that is a subclass of Character
 */
public class Ranger extends Character {
    
    /**
     * Constructor
     * @param name The name of the character
     */
    public Ranger(String name) {
        super(name);
        setClassName("Ranger");
        Stats stats = StatGenerator.generate(StatType.SPEED);
        setToughness(stats.getThoughness());
        setIntelligence(stats.getIntelligence());
        setSpeed(stats.getSpeed());
    }

    /**
     * Prints out how a ranger attacks.
     */
    public void attack() {
        System.out.println("Fires bow!\n");
    }

    /**
     * Returns the class name
     */
    public String printClassName() {
        return "Ranger";
    }
}