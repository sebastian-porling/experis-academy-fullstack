package java_basics.c;

import java.util.ArrayList;

/**
 * This program generates a list of persons and prints them out in the console
 */
public class PersonProgram {

    /**
     * Generates a list of persons in an ArrayList and prints them out
     * in the console.
     * @param args Arguments are ignored
     */
    public static void main(String[] args) {
        
        ArrayList<Person> persons = generatePersonList();
        printPersons(persons);
    }

    /**
     * Generates an ArrayList with the object person.
     * @return A list of five persons
     */
    private static ArrayList<Person> generatePersonList() {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("John MacDoe", "1995-05-25", "+47925813885"));
        persons.add(new Person("Alice Smith", "1960-03-10", "+32294052960"));
        persons.add(new Person("Marie Torsdotter", "1976-11-30", "+46702349658"));
        persons.add(new Person("Jacob Thunderstruck", "2000-07-18", "+77203952091"));
        persons.add(new Person("Carl Flop", "2008-12-26", "+32209652839"));
        return persons;
    }

    /**
     * Prints a list of persons in the console.
     * @param persons List to be printed out
     */
    private static void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}