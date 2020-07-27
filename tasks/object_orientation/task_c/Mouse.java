
import animalType.*;

/**
 * This class represents a mouse
 */
public class Mouse extends Omnivore {
    private String sound = "Squeek";

    /**
     * Constructor
     */
    public Mouse() {
        super();
    }

    /**
     * @return A string of what a mouse running sounds like
     */
    @Override
    public String run() {
        return "Squeek, pat, pat, pat";
    }

    /**
     * @return A string of what a mouse walking sounds like
     */
    @Override
    public String walk() {
        return "Pat, pat, pat";
    }
    
    /**
     * Prints the sound a mouse makes
     */
    @Override
    public void makeNoise() {
        System.out.println(sound);
    }
}