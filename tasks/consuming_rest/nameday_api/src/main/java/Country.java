import java.util.stream.Stream;

/**
 * Enum that represents information of countries
 */
public enum Country {
    SWEDEN("se", "Sweden"),
    DENMARK("dk", "Denmark"),
    USA("us", "The United States of America");

    private final String CODE;
    private final String FULL_NAME;

    /**
     * Constructor
     * @param code the country code
     * @param fullName the full name of the country
     */
    Country(String code, String fullName) {
        this.CODE = code;
        this.FULL_NAME = fullName;
    }

    public String getCode() {
        return CODE;
    }

    public String getFullName() {
        return FULL_NAME;
    }

    /**
     * Creates a stream for all values of Enum Country
     * @return Stream of countries
     */
    public static Stream<Country> stream() {
        return Stream.of(Country.values());
    }
}
