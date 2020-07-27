package animalType;

/**
 * Class that represents an omnivore.
 */
public abstract class Omnivore extends Animal {

    /**
     * Returns a string of what omnivores eat.
     */
    public String eats() {
        return "This animal eats everything.";
    }

    /**
     * Methods that has to be implemented by an animal that is an omnivore
     */
    public abstract void makeNoise();
}