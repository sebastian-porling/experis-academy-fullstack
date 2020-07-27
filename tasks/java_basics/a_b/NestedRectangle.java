package java_basics.a_b;

/**
 * A class that generates a rectangle with a nested rectangle that can be printed in the command line.
 */
public class NestedRectangle extends Rectangle {
    private int innerHeight;
    private int innerWidth;

    /**
     * Constructor
     */
    public NestedRectangle(int height, int width){
        super(height, width);
        this.innerHeight = height - 2;
        this.innerWidth = width - 2;
    }

    /**
     * Generates a rectangle, with a nested rectangle represented as a string
     */
    private void generateNestedRectangle(){
        for (int i = 1; i <= this.height; i++) {
            for (int j = 1; j <= this.width; j++) {
                if (i == 1 || i == this.height) {
                    rectangleOutput += this.BORDER;
                } else if (j == 1 || j == this.width) {
                    rectangleOutput += this.BORDER;
                } else if ((i == 3 || i == this.innerHeight) && (j > 2 && j < this.innerWidth+1)){
                    rectangleOutput += this.BORDER;
                } else if ((j == 3 || j == this.innerWidth) && (i > 2 && i < this.innerHeight+1)){
                    rectangleOutput += this.BORDER;
                } 
                else {
                    rectangleOutput += this.SPACE;
                }
            }
            this.rectangleOutput += this.NEW_LINE;
        }
    }

    /**
     * Chooses between a normal rectangle or a rectangle with a nested rectangle to be printed.
     */
    public String toString() {
        if (validRectangleSize(innerHeight-2, innerWidth-2)) {
            generateNestedRectangle();
        } else {
            generateRectangle();
        }
        return rectangleOutput;
    }
}