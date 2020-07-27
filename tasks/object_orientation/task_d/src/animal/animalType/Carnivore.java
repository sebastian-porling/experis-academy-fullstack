package src.animal.animalType;

/**
 * Class that represents a carnivore
 */
public abstract class Carnivore extends Animal {
    
    /**
     * Returns a string of what carnivores eat.
     */
    public String eats() {
        return "This animal eats meat.";
    }

    /**
     * The sound a carnivore animal makes
     */
    public abstract void makeNoise();
}