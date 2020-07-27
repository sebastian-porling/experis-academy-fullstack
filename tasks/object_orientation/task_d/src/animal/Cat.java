package src.animal;

import src.animal.animalType.*;

/**
 * This class represents a cat
 */
public class Cat extends Carnivore {
    String sound = "Meow";

    /**
     * Constructor
     */
    public Cat() {
        super();
    }

    /**
     * @return The sound of a cat running
     */
    @Override
    public String run() {
        return "Brrrr, paw, paw, paw, paw";
    }

    /**
     * @return The sound of a cat walking
     */
    @Override
    public String walk() {
        return "Paw, paw, paw";
    }

    /**
     * Prints out the sound a cat makes
     */
    @Override
    public void makeNoise() {
        System.out.println(sound);
    }
    
}