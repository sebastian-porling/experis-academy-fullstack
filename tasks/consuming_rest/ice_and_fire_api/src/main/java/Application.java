
import java.util.*;

import api.Book;
import api.Character;
import api.IceAndFireAPI;

public class Application {
    private static Scanner scanner;

    /**
     * Main method
     * @param args Takes in one argument, the id of a character.
     */
    public static void main(String... args) {
        int characterId = getUserInput(args);
        Character character = IceAndFireAPI.getCharacter(characterId);
        System.out.println(Character.formatingTemplate());
        System.out.println(character);

        printSwornMembers(character, characterId);

        printPovFromBantaBooks();

        scanner.close();
    }

    /**
     * Prints out the sworn members of a character
     * @param character Character
     * @param characterId id of the character
     */
    private static void printSwornMembers(Character character, int characterId) {
        if(userWantsSwornMembers()) {
            Set<Character> swornMembers = IceAndFireAPI.getHouseSwornMembersOfCharacter(characterId);
            printSeperator();
            System.out.println("All sworn members of " + IceAndFireAPI.getHouse(character.allegiances[0]));
            System.out.println(Character.formatingTemplate());
            swornMembers.forEach(System.out::println);
        }
    }

    /**
     * Prints out the books and their pov characters side by side!
     */
    private static void printPovFromBantaBooks() {
        Set<Book> books = IceAndFireAPI.getBantamBooks();
        printSeperator();
        for (Book book : books) {
            System.out.print(book.name.subSequence(0, 16) + "\t");
        }
        System.out.println();
        Book[] booksArray = new Book[books.size()];
        int k = 0;
        for (Book book : books) {
            booksArray[k++] = book;
        }
        int maxLength = maxPovListSize(books);
        for (int j = 0; j < maxLength; j++) {
            for (Book book : booksArray) {
                if (book.povCharacters.length > j) {
                    String output = IceAndFireAPI.getCharacter(book.povCharacters[j]).name;
                    String tab = output.length() < 12 ? output.length() < 8 ? "\t\t\t\t" : "\t\t\t" : output.length() > 15 ? "\t" : "\t\t";
                    System.out.print(IceAndFireAPI.getCharacter(book.povCharacters[j]).name + tab);
                } else {
                    System.out.print("\t\t\t\t\t");
                }
            }
            System.out.println();
        }
    }

    /**
     * Gets the maximum size of the pov character lists
     * @param books The books with pov character arrays
     * @return maximum size of the arrays
     */
    private static int maxPovListSize(Set<Book> books) {
        int maxLength = 0;
        for (Book book : books) {
            int sum = 0;
            for (int i = 0; i < book.povCharacters.length; i++) {
                sum++;
            }
            maxLength = Math.max(sum, maxLength);
        }
        return maxLength;
    }

    /**
     * Prints out a seperator
     */
    private static void printSeperator(){
        System.out.println("############################################################");
    }

    /**
     * Checks of the user wants to see sworn members
     * @return if the user wants to check sworn members
     */
    public static boolean userWantsSwornMembers(){
        scanner = new Scanner(System.in);
        String userInput = "";
        System.out.println("\n Do you want to see all sworn members of the characters house? (y/n): ");
        userInput = scanner.nextLine();
        return userInput.equals("y");
    }

    /**
     * Gets the id for a character to look up in the API from user
     * @param args first argument numeric
     * @return character id to look up
     */
    public static int getUserInput(String... args) {
        scanner = args.length == 1 ? new Scanner(args[0]) :
                new Scanner(System.in);
        System.out.println("Enter character id: ");
        int characterId = 0;
        try {
            characterId = scanner.nextInt();
        } catch (Exception e) {
            characterId = getUserInput(new String[0]);
        }
        return characterId;
    }
}
