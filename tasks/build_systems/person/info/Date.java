package person.info;

/**
 * This class represents a date in the format:
 * yyyy-mm-dd
 */
public class Date {
    int day;
    int month;
    int year;

    /**
     * Constructor
     * @param year a year between 0-9999
     * @param month a month between 0-12
     * @param day a month beween 0-31
     */
    public Date(int year, int month, int day) {
        this.year = year % 9999;
        this.month = month > 12 || month < 0 ? month % 12 : month;
        this.day = day > 31 || day < 0 ? day % 31 : day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}