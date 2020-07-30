
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import person.info.*;
import person.*;
import util.Command;

/**
 * @author Sebastian Porling
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * This main program lets a user search through 10 users.
     * @param args are ignored
     */
    public static void main(String[] args) {
        List<Person> persons = generatePersons();
        PersonSearcher searcher = new PersonSearcher(persons);
        boolean running = true;

        while(running) {
            Command userCommand = getCommand();
            List<Person> filteredPersons = processCommand(userCommand, searcher);
            printResult(filteredPersons);
        }
        scanner.close();
    }

    /**
     * Prints the persons matching the user query
     * @param filteredPersons matching persons
     */
    private static void printResult(List<Person> filteredPersons){
        if (filteredPersons.size() == 0) {
            System.out.println("\nNo person matches your search query... \n");
        } else {
            System.out.println("\nThese matches your search query: ");
            filteredPersons.forEach(System.out::println);
            System.out.println();
        }
    }

    /**
     * Checks what kind of search query the user want to make
     * Then gets necessary user input and makes the search.
     * @param userCommand user command
     * @param searcher a person searcher
     * @return list of persons matching the search.
     */
    private static List<Person> processCommand(Command userCommand, PersonSearcher searcher) {
        String userInput = "";
        List<Person> filteredPersons = new ArrayList<Person>();
        switch (userCommand) {
            case NAME:
                userInput = getUserInput("Enter the persons name: ");
                filteredPersons = searcher.matchingName(userInput);
                break;
            case STREET:
                userInput = getUserInput("Enter the persons street: ");
                filteredPersons = searcher.matchingStreet(userInput);
                break;
            case ZIP_CODE:
                userInput = getUserInput("Enter the persons zip code: ");
                filteredPersons = searcher.matchingZipCode(userInput);
                break;
            case CITY:
                userInput = getUserInput("Enter the persons city: ");
                filteredPersons = searcher.matchingCity(userInput);
                break;
            case COUNTRY:
                userInput = getUserInput("Enter the persons country: ");
                filteredPersons = searcher.matchingCountry(userInput);
                break;
            case PHONE_NUMBER:
                userInput = getUserInput("Enter the persons phone number: ");
                filteredPersons = searcher.matchingPhoneNumber(userInput);
                break;
            case WORK_NUMBER:
                userInput = getUserInput("Enter the persons work number: ");
                filteredPersons = searcher.matchingWorkNumber(userInput);
                break;
            case DATE_OF_BIRTH:
                userInput = getUserInput("Enter the persons date of birth (yyyy-mm-dd): ");
                filteredPersons = searcher.matchingDateOfBirth(userInput);
                break;
            default:
                break;
        }
        return filteredPersons;
    }

    /**
     * Prompts a message and gets user input.
     * @return user input as String
     */
    private static String getUserInput(String message) {
        System.out.println(message);
        String userInput = "";
        if (scanner.hasNext()){
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    /**
     * Promts the user with available commands
     * Then parses the command and returns it.
     * @return user command.
     */
    private static Command getCommand() {
        System.out.println("Search for a person with the following options: ");
        System.out.println("1. Name");
        System.out.println("2. Street");
        System.out.println("3. Zip Code");
        System.out.println("4. City");
        System.out.println("5. Country");
        System.out.println("6. Phone Number");
        System.out.println("7. Work Number");
        System.out.println("8. Date of Birth");
        System.out.println("9. Exit Program");
        System.out.println("Enter the number here: ");
        int userOption = 9;
        String userInput = "";
        if (scanner.hasNext()){
            userInput = scanner.nextLine();
            userOption = Integer.parseInt(userInput);
        }
        Command userCommand = null;
        switch (userOption) {
            case 1:
                userCommand = Command.NAME;
                break;
            case 2:
                userCommand = Command.STREET;
                break;
            case 3:
                userCommand = Command.ZIP_CODE;
                break;
            case 4:
                userCommand = Command.CITY;
                break;
            case 5:
                userCommand = Command.COUNTRY;
                break;
            case 6:
                userCommand = Command.PHONE_NUMBER;
                break;
            case 7:
                userCommand = Command.WORK_NUMBER;
                break;
            case 8:
                userCommand = Command.DATE_OF_BIRTH;
                break;
            case 9:
                System.out.println("Thank you for your time!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invallid option, try again...");
                userCommand = getCommand();
                break;
        }
        return userCommand;
    }

    /**
     * Generates 10 persons with some common information.
     * @return list of persons.
     */
    private static ArrayList<Person> generatePersons(){
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person(
            "John Doe", 
            new Address("31th West Avenue", "19523", "New York", "USA"), 
            new PhoneNumber("08-213 123 2"), 
            new WorkNumber("56021"), 
            new Date(1956, 2, 25)));
        persons.add(new Person(
            "John Martin", 
            new Address("25th East Avenue", "54523", "Washington", "USA"), 
            new PhoneNumber("07-412 123 1"), 
            new WorkNumber("54231"), 
            new Date(1967, 5, 29)));
        persons.add(new Person(
            "Martha Doe", 
            new Address("31th West Avenue", "19523", "New York", "USA"), 
            new PhoneNumber("06-221 433 2"), 
            new WorkNumber("66021"), 
            new Date(1985, 11, 2)));
        persons.add(new Person(
            "Martin Smith", 
            new Address("4h Elm Street", "61235", "San Fransisco", "USA"), 
            new PhoneNumber("08-213 123 2"), 
            new WorkNumber("56021"), 
            new Date(1993, 12, 5)));
        persons.add(new Person(
            "Sean Connor", 
            new Address("58th Maker Avenue", "92313", "London", "England"), 
            new PhoneNumber("123-141 231 2"), 
            new WorkNumber(61231), 
            new Date(1988, 6, 17)));
        persons.add(new Person(
            "Johannes Svensson", 
            new Address("Långgatan 35", "10203", "Stockhom", "Sweden"), 
            new PhoneNumber("073-123 12 12"), 
            new WorkNumber(95231), 
            new Date(1991, 8, 11)));
        persons.add(new Person(
            "Agnes Andersdotter", 
            new Address("Grannviken 55", "18923", "Norrtälje", "Sweden"), 
            new PhoneNumber("074-123 51 51"), 
            new WorkNumber("00612"), 
            new Date(1976, 4, 1)));
        persons.add(new Person(
            "Mohammed Alsabti", 
            new Address("5th Kalmar Street", "61212", "Cape Town", "South Africa"), 
            new PhoneNumber("042-123 125 123"), 
            new WorkNumber("40123"), 
            new Date(1967, 8, 5)));
        persons.add(new Person(
            "Hans Huler", 
            new Address("Gurtstrasse 56", "55221", "Berlin", "Germany"), 
            new PhoneNumber("023-145 22 1"), 
            new WorkNumber("40123"), 
            new Date(1988, 6, 17)));
        persons.add(new Person(
            "Hans Connor", 
            new Address("99th Elm Street", "61235", "San Fransisco", "USA"), 
            new PhoneNumber("08-512 612 2"), 
            new WorkNumber("00001"), 
            new Date(1991, 8, 11)));
        return persons;
    }
}