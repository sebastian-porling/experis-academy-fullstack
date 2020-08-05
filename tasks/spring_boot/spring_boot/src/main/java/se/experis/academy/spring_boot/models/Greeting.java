package se.experis.academy.spring_boot.models;

/**
 * Represents a greeting
 */
public class Greeting {
    private final int id;
    private final String content;

    /**
     * Constructor
     * @param id int
     * @param content string
     */
    public Greeting(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
