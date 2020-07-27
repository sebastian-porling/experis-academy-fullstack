package animalType;

import movement.*;

/**
 * This class represents an animal that can run and walk.
 */
public abstract class Animal implements Runable, Walkable{

    /**
     * The sound an animal make
     */
    public abstract void makeNoise();

    /**
     * Returns what the animal eats.
     */
    public abstract String eats();
}