package api;

import com.google.gson.Gson;
import org.json.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class has methods to call the api of ice and fire!
 */
public class IceAndFireAPI {
    private static final String API_URL = "https://anapioficeandfire.com/api/";

    /**
     * Gets all POV characters from the bantam books
     * @return pov characters as a set
     */
    public static Set<Character> getAllPOVCharacters() {
        Set<Book> povBooks = getBantamBooks();
        return povBooks.stream().map(book ->
                Arrays.stream(book.povCharacters)
                .map(IceAndFireAPI::getCharacter)
                        .collect(Collectors.toSet()))
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Gets all the bantam books
     * @return bantam books as a set
     */
    public static Set<Book> getBantamBooks() {
        String urlString = API_URL + "books";
        JSONArray json = new JSONArray(getRequest(urlString));
        Set<Book> povBooks = new HashSet<>();
        for (int i = 0; i < json.length(); i++) {
            Gson gson = new Gson();
            Book book = gson.fromJson(json.getJSONObject(i).toString(), Book.class);
            if (book.publisher.equals("Bantam Books")) {
                povBooks.add(book);
            }
        }
        return povBooks;
    }

    /**
     * Gets pov characters from a book
     * @param book the book
     * @return pov characters as a set
     */
    public static Set<Character> getPovCharacterFromBook(Book book) {
        return Arrays.stream(book.povCharacters)
                .map(IceAndFireAPI::getCharacter)
                .collect(Collectors.toSet());
    }

    /**
     * Gets a character with a id
     * @param id the id
     * @return a character
     */
    public static Character getCharacter(int id) {
        String urlString = API_URL + "characters/" + id;
        return getCharacter(urlString);
    }

    /**
     * Gets a character from url
     * @param urlString the url
     * @return a character
     */
    public static Character getCharacter(String urlString) {
        Gson gson = new Gson();
        Character character = null;
        try {
            character = gson.fromJson(getRequest(urlString), Character.class);
        } catch (NullPointerException e) {
            System.out.println("Character doesn't exist!");
        }
        return character;
    }

    /**
     * Gets a house from with id
     * @param houseId the id
     * @return a house
     */
    public static House getHouse(int houseId) {
        String urlString = API_URL + "houses/" + houseId;
        return getHouse(urlString);
    }

    /**
     * Gets a house from url
     * @param urlString the urö
     * @return a house
     */
    public static House getHouse(String urlString) {
        Gson gson = new Gson();
        return gson.fromJson(getRequest(urlString), House.class);
    }

    /**
     * Gets a set of characters from the character id house
     * @param id character id
     * @return set of characters
     */
    public static Set<Character> getHouseSwornMembersOfCharacter(int id) {
        Character character = getCharacter(id);
        return Arrays.stream(character.allegiances)
                .map(IceAndFireAPI::getHouseSwornMembers)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    /**
     * Gets the sworn members of a house
     * @param houseId house id
     * @return set of characters
     */
    private static Set<Character> getHouseSwornMembers(int houseId) {
        String urlString = API_URL+ "houses/" + houseId;
        return getHouseSwornMembers(urlString);
    }

    /**
     * Gets a set of characters that are sworn members in a house from a url
     * @param urlString the url
     * @return set of characters
     */
    private static Set<Character> getHouseSwornMembers(String urlString) {
        Gson gson = new Gson();
        House house = gson.fromJson(getRequest(urlString), House.class);
        return Arrays.stream(house.swornMembers)
                .map(IceAndFireAPI::getCharacter)
                .collect(Collectors.toSet());
    }

    /**
     * Makes a url request to the api
     * @param urlRequest the url
     * @return String response
     */
    private static String getRequest(String urlRequest) {
        String result = "";
        try {
            URL url = new URL(urlRequest);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();

                result = content.toString();
            } else {
                System.out.println("Error");
                System.out.println("Server responded with: " + con.getResponseCode());
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
