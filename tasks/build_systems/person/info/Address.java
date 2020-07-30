package person.info;

/**
 * This class represents an address with a street, zip code, city and country.
 */
public class Address {
    private String street;
    private String zipCode;
    private String city;
    private String country;

    /**
     * Constructor
     * @param street String
     * @param zipCode String
     * @param city String
     * @param country String
     */
    public Address(String street, String zipCode, String city, String country) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
    
    /**
     * Constructor
     * @param street String
     * @param zipCode Integer
     * @param city String
     * @param country String
     */
    public Address(String street, int zipCode, String city, String country) {
        this.street = street;
        this.zipCode = "" + zipCode;
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + zipCode + ", " + city + ", " + country;
    }
}