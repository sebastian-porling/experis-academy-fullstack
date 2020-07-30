package person.info;

/**
 * 
 */
public class PhoneNumber {
    private String phoneNumber;

    /**
     * Constructor
     * @param phoneNumber String
     */
    public PhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Constructor
     * @param phoneNumber Integer
     */
    public PhoneNumber(int phoneNumber) {
        this.phoneNumber = "" + phoneNumber;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}