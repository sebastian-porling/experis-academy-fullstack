package model;

import java.util.List;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private List<Genre> mostPopularGenres;

    public Customer(int customerId, String firstName, String lastName, List<Genre> mostPopularGenres) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mostPopularGenres = mostPopularGenres;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Genre> getMostPopularGenres(){
        return mostPopularGenres;
    }
}
