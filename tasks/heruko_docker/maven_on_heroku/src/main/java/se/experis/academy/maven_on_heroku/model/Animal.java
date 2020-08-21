package se.experis.academy.maven_on_heroku.model;

import javax.persistence.*;

/**
 *  Represents the animal data object and table
 */
@Entity(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    public Animal(){}

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
