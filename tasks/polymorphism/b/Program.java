import java.util.ArrayList;
import java.util.Random;
import characters.Character;
import characters.*;

/**
 * This class generates characters and picks one at random to display character information in console.
 */
public class Program {

    /**
     * The main program
     * @param args Arguments are ignored
     */
    public static void main(String[] args) {
        ArrayList<Character> party = generateParty();

        Character randomCharacter = getRandomCharacter(party);

        showCharacterInformation(randomCharacter);
    }

    /**
     * Generates a list of characters
     * @return ArrayList with four characters
     */
    private static ArrayList<Character> generateParty() {
        ArrayList<Character> party = new ArrayList<>();

        party.add(new Warrior("Notsium"));
        party.add(new Ranger("Krov"));
        party.add(new Wizard("Matimeo"));
        party.add(new Ranger("Split"));

        return party;
    }

    /**
     * Gets a random character from a Character arraylist
     * @param party the list of characters
     * @return random character
     */
    private static Character getRandomCharacter(ArrayList<Character> party) {
        Random random = new Random();
        return party.get(random.nextInt(party.size()-1));
    }

    /**
     * Prints out the infromation and attack of a character
     * @param character The character which info is going to be displayed
     */
    private static void showCharacterInformation(Character character) {
        character.displayStats();
        character.attack();
        System.out.println(character.printClassName());
    }
}