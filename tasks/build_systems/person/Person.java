package person;

import person.info.*;

/**
 * This class represents a person
 */
public class Person {
    private String fullName;
    private Address address;
    private PhoneNumber phoneNumber;
    private WorkNumber workNumber;
    private Date dateOfBirth;

    /**
     * Constructor
     */
    public Person(String fullName, Address address, PhoneNumber phoneNumber, WorkNumber workNumber, Date dateOfBirth) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.workNumber = workNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName(){
        return fullName;
    }

    public Address getAddress() {
        return address;
    }

    public String getAddressAsString() {
        return address.toString();
    }

    public String getPhoneNumber() {
        return phoneNumber.toString();
    }

    public String getWorkNumber() {
        return workNumber.toString();
    }

    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    @Override
    public String toString() {
        return fullName + ", " + address.toString() + ", " + 
        phoneNumber.toString() + ", " + workNumber.toString() + 
        ", " + dateOfBirth.toString();
    }
}