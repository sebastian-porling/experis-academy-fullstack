package characters;

/**
 * This class represents a character that has stats, name and class name
 */
public abstract class Character {
    private String name;
    private int toughness;
    private int speed;
    private int intelligence;
    private String className;

    /**
     * Constructor
     * @param name The name of the character
     */
    public Character(String name) {
        this.name = name;
    }

    /**
     * Dipslays the characters name, class and stats.
     */
    public void displayStats() {
        System.out.println(name + " the " + printClassName() + "\n");
        System.out.println("Tough: " + toughness);
        System.out.println("Speed: " + speed);
        System.out.println("Intel: " + intelligence);
    }

    /**
     * Prints out how the character attacks
     */
    public abstract void attack();

    /**
     * Returns a string of the class name
     */
    public abstract String printClassName();

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}