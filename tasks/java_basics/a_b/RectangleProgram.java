package java_basics.a_b;

import java_basics.a_b.*;

/**
 * This program takes in three arguments, height and width represented as positive numbers,
 * and a false or true value if the program should generate nested rectangle or not.
 * Ex. RectangleProgram 8 8 true
 */
public class RectangleProgram {
    
    /**
     * The main class
     * Checks if the arguments are valid, and if the input is valid.
     */
    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Need two arguments; java RectangleProgram <height> <width> <nested>");
            System.out.println("Where width and heigth are integers, and nested is a boolean.");
            System.exit(0);
        }

        Rectangle rectangle;
        boolean isNested;
        int height = stringToInteger(args[0]);
        int width = stringToInteger(args[1]);
        validateSize(height);
        validateSize(width);
        isNested = Boolean.parseBoolean(args[2]);
        rectangle = isNested ? new NestedRectangle(height, width) : new Rectangle(height, width);

        System.out.println(rectangle);
    }

    /**
     * Checks if the size is bigger than three.
     */
    private static void validateSize(int size) {
        if (!(size > 2)) {
            System.out.println("The size of one of the sides are less than 3, try again.");
            System.exit(0);
        }
    }

    /**
     * Parses string to integer
     */
    private static int stringToInteger(String toConvert) {
        int result = 0;
        try {
            result = Integer.parseInt(toConvert);
        } catch (Exception e) {
            System.out.println("The argument: " + toConvert + " is not a number.");
            System.out.println("Try again with numbers!");
            System.exit(0);
        }
        return result;
    }
}