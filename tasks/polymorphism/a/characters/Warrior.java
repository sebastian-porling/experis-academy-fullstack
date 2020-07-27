package characters;

import characters.stats.StatGenerator;
import characters.stats.StatType;
import characters.stats.Stats;

/**
 * This class represents a warrior which is a subclass of character
 */
public class Warrior extends Character {
    
    /**
     * Constructor, generates the stats and sets the class name.
     * @param name The name of the character
     */
    public Warrior(String name) {
        super(name);
        setClassName("Warrior");
        Stats stats = StatGenerator.generate(StatType.THOUGHNESS);
        setToughness(stats.getThoughness());
        setIntelligence(stats.getIntelligence());
        setSpeed(stats.getSpeed());
    }

    /**
     * Prints out how the warrior attacks
     */
    public void attack() {
        System.out.println("Swings sword\n");
    }

    /**
     * @return The class name
     */
    public String printClassName() {
        return "Warrior";
    }
}