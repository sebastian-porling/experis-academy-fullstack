package java_basics.c;

/**
 * Class representing a person
 */
public class Person {
    private String fullName;
    private String birthday;
    private String phoneNumber;

    /**
     * Constructor
     * @param fullName Fullname of the person, ex. Margeret Lou
     * @param birthday Birthday of the person, ex. 2018-04-21
     * @param phoneNumber Phonenumber of the person, ex. +46072932984
     */
    public Person(String fullName, String birthday, String phoneNumber) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Returns the person instance as: 
     * ex. Name: Margeret Lou, Birthday: 2018-04-21, Telephone number: +46072932984
     */
    public String toString() {
        return "Name: " + this.fullName + ", Birthday: " + this.birthday 
                + ", Telephone number: " + this.phoneNumber;
    }
}