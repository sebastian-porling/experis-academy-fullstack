package src.animal;

import src.animal.animalType.*;

/**
 * This class represents a sheep
 */
public class Sheep extends Herbivore {
    private String sound = "Bääää";

    /**
     * Constructor
     */
    public Sheep() {
        super();
    }

    /**
     * @return The sound of a sheep walking
     */
    @Override
    public String walk() {
        return "Bäää, stomp, stomp.";
    }

    /**
     * @return The sound of a sheep running
     */
    @Override
    public String run() {
        return "Stomp, stomp, stomp, stomp";
    }

    /**
     * Prints out the sound of a sheep
     */
    @Override
    public void makeNoise() {
        System.out.println(sound);
    }
}