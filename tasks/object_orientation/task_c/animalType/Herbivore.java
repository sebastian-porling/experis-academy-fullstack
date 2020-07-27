package animalType;

/**
 * Class that represents a herbivore
 */
public abstract class Herbivore extends Animal {
    
    /**
     * Returns a string of what herbivores eat.
     */
    public String eats() {
        return "This animal eats veggies and fruits";
    }

    /**
     * The sound that a herbivore animal makes
     */
    public abstract void makeNoise();
}