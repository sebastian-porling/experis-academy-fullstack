import java.util.Scanner;

/**
 * Takes in how many rows of the Floyd's Triangle 
 * to generate and print
 */
public class Sebastian {
    public static int[][] floyds;
    
    /**
     * Main
     * @param args First argument as number of rows
     */
    public static void main(String... args) {
        int rows = userInput(args);
        floyds = new int[rows][rows];
        generateFloydsTriangle(rows);
        printFloydsTriangle();
    }

    /**
     * Takes in the number of rows from user
     * @param args Forst argu,emt as number of rows
     * @return Number of rows
     */
    public static int userInput(String... args){
        Scanner scanner = args.length == 1 ? new Scanner(args[0]) : new Scanner(System.in);
        System.out.println("Enter the number of rows for floyd's triangle: ");
        int rows = 0;
        try {
            rows = scanner.nextInt();
        } catch (Exception e) {
            rows = userInput(new String[0]);
        }
        scanner.close();
        return rows;
    }

    /**
     * Generates the floyds triangle in a global array
     * @param rows Number of rows to generate
     */
    public static void generateFloydsTriangle(int rows) {
        int number = 1;
        for (int col = 1; col <= rows; col++) {
            for (int i = 1; i <= col; i++) {
                floyds[col-1][i-1] = number;
                number++;
            }
        }
    }

    /**
     * Prints out Floyd's Triangle from global array
     */
    public static void printFloydsTriangle() {
        System.out.println("Floyd's triangle");
        System.out.println("****************");
        for (int[] row : floyds) {
            for (int num : row) {
                if (num == 0) {
                    break;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}