package se.experis.academy.gradle_on_heroku.model;

import javax.persistence.*;

@Entity(name = "jokes")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "joke", nullable = false)
    private String joke;

    public Joke(){}

    public Joke(String joke){
        this.joke = joke;
    }

    public long getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }
}
