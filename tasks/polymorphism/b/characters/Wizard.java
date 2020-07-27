package characters;

import characters.stats.StatGenerator;
import characters.stats.StatType;
import characters.stats.Stats;

/**
 * This class represents a wizard that is a sublcass of character
 */
public class Wizard extends Character {
    
    /**
     * Constructor
     * @param name the name of the character
     */
    public Wizard(String name) {
        super(name);
        setClassName("Wizard");
        Stats stats = StatGenerator.generate(StatType.INTELLIGENCE);
        setToughness(stats.getThoughness());
        setIntelligence(stats.getIntelligence());
        setSpeed(stats.getSpeed());
    }

    /**
     * Prints out how a wizard attacks
     */
    public void attack() {
        System.out.println("Casts firebolt!\n");
    }

    /**
     * Prints out the class name
     */
    public String printClassName() {
        return "Wizard";
    }
}