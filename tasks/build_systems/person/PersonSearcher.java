package person;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class can search through persons with different search queries.
 */
public class PersonSearcher {
    private List<Person> persons;

    /**
     * Constructor
     * @param persons List of persons
     */
    public PersonSearcher(List<Person> persons) {
        this.persons = persons;
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    /**
     * Finds all persons that match the provided name
     * @param NAME String
     * @return list of persons
     */
    public List<Person> matchingName(final String NAME) {
        return persons.stream()
                .filter(person -> person.getFullName().contains(NAME))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided street
     * @param STREET String
     * @return list of persons
     */
    public List<Person> matchingStreet(final String STREET) {
        return persons.stream()
                .filter(person -> person.getAddress().getStreet().contains(STREET))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided city
     * @param CITY String
     * @return list of persons
     */
    public List<Person> matchingCity(final String CITY) {
        return persons.stream()
                .filter(person -> person.getAddress().getCity().contains(CITY))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided zip code
     * @param ZIP_CODE String
     * @return list of persons
     */
    public List<Person> matchingZipCode(final String ZIP_CODE) {
        return persons.stream()
                .filter(person -> person.getAddress().getZipCode().contains(ZIP_CODE))
                .collect(Collectors.toList());
    }   

    /**
     * Finds all persons that match the provided country
     * @param COUNTRY String
     * @return list of persons
     */
    public List<Person> matchingCountry(final String COUNTRY) {
        return persons.stream()
                .filter(person -> person.getAddress().getCountry().contains(COUNTRY))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided phone number
     * @param PHONE_NUMBER String
     * @return list of persons
     */
    public List<Person> matchingPhoneNumber(final String PHONE_NUMBER) {
        return persons.stream()
                .filter(person -> person.getPhoneNumber().contains(PHONE_NUMBER))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided work number
     * @param WORK_NUMBER String
     * @return list of persons
     */
    public List<Person> matchingWorkNumber(final String WORK_NUMBER) {
        return persons.stream()
                .filter(person -> person.getWorkNumber().contains(WORK_NUMBER))
                .collect(Collectors.toList());
    }

    /**
     * Finds all persons that match the provided date
     * @param DATE_OF_BIRTH String
     * @return list of persons
     */
    public List<Person> matchingDateOfBirth(final String DATE_OF_BIRTH) {
        return persons.stream()
                .filter(person -> person.getDateOfBirth().contains(DATE_OF_BIRTH))
                .collect(Collectors.toList());
    }
}