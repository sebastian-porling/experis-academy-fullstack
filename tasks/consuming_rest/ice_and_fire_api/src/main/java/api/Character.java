package api;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a character from the api
 */
public class Character {
    public String url;
    public String name;
    public String gender;
    public String culture;
    public String born;
    public String died;
    public String[] titles;
    public String[] aliases;
    public String father;
    public String mother;
    public String spouse;
    public String[] allegiances;
    public String[] books;
    public String[] povBooks;
    public String[] tvSeries;
    public String[] playedBy;

    public static String formatingTemplate(){
        return String.format("%-20s %-10s %-20s", "NAME", "GENDER", "TITLES");
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-20s", name, gender, Arrays.toString(titles));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character that = (Character) o;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url);
    }
}
