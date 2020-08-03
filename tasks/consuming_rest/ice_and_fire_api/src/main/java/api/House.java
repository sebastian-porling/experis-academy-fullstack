package api;

/**
 * Represents a house from the api
 */
public class House {
    public String url;
    public String name;
    public String region;
    public String coatOfArms;
    public String words;
    public String[] titles;
    public String[] seats;
    public String currentLord;
    public String heir;
    public String overlord;
    public String founded;
    public String founder;
    public String diedOut;
    public String[] ancestralWeapons;
    public String[] cadetBranches;
    public String[] swornMembers;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", name, region, coatOfArms, words);
    }
}
