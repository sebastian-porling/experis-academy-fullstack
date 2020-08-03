package api;

import java.util.Date;

/**
 * Represents a book from the api
 */
public class Book {
    public String url;
    public String name;
    public String isbn;
    public String[] authors;
    public int numberOfPages;
    public String publisher;
    public String country;
    public String mediaType;
    public Date date;
    public String[] characters;
    public String[] povCharacters;

    public static String formatTemplate() {
        return String.format("%-20s %-20s %-20s %-20s %-20s", "BOOK NAME", "ISBN", "MEDIA", "#PAGES", "PUBLISHER");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-20d %-20s", name, isbn, mediaType, numberOfPages, publisher);
    }
}