package person.info;

/**
 * This class represents a work number
 */
public class WorkNumber {
    private String workNumber;

    /**
     * Constructor
     * @param workNumber String
     */
    public WorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    /**
     * Constructor
     * @param workNumber Integer
     */
    public WorkNumber(int workNumber) {
        this.workNumber = "" + workNumber;
    }

    @Override
    public String toString() {
        return workNumber;
    }
}