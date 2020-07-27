package java_basics.a_b;

/**
 * A class that generates a rectangle as a string that can be printed in the command line.
 */
public class Rectangle {
    protected int height;
    protected int width;
    protected String rectangleOutput = "";
    protected final String BORDER = "#";
    protected final String SPACE = " ";
    protected final String NEW_LINE = "\n";

    /**
     * Constructor
     */
    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;  
    }

    /**
     * Generates the output for the rectangle represented as a string.
     */
    protected void generateRectangle(){
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                if ((i == 1) || (i == this.height)){
                    this.rectangleOutput += this.BORDER;
                } else {
                    this.rectangleOutput += isEdge(j) ? this.BORDER : this.SPACE;
                }
            }
            this.rectangleOutput += this.NEW_LINE;
        }
    }

    /**
     * Checks if the rectangle is of valid size, bigger than 3x3.
     */
    protected boolean validRectangleSize(int heigth, int width){
        return ((height > 2) && (width > 2));
    }

    /**
     * Checks of the candidate is at the edge of the rectangle
     */
    protected boolean isEdge(int candidate) {
        return ((candidate == 1) || (candidate == this.width));
    }

    /**
     * Makes the rectangle object to a string
     */
    public String toString(){
        generateRectangle();
        return rectangleOutput;
    }
}