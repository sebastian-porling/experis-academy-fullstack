
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program gives the full path of a existing file
 * and the size of the file in bytes, kb and mb.
 * If the file is a ".txt" file you will be able to get
 * the frequency of a word of your choice.
 */
public class Program {
    private final static String DELIMITOR = "[\\s,;-]+";

    /**
     * Main program
     * @param args arguments are ignored
     */
    public static void main(String[] args) {
        /* Open up the scanner with standard input */
        Scanner scanner = new Scanner(System.in);

        /* Get the file name */
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();

        /*  Check if the file could be a ".txt" file
            Then prompt for a word to find the frequency for */
        String wordToFind = "";
        if (validTxtExtensionSize(fileName) && isTxtFile(fileName)) {
            System.out.println("Choose a word to find word frequency: ");
            wordToFind = scanner.nextLine().toLowerCase();
        }

        /*  Open up the file and check if it exists, 
            Print its full path,
            Calculate the file size,
            and check for word frequency of a ".txt" file */
        try {
            File file = new File(fileName);
            checkFile(file);
            printFilePath(file);
            calculateFileSize(file);
            if (wordToFind != "") {
                findWordFrequency(file, wordToFind);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        
    }

    /**
     * Checks if the file is longer than three in order to be able
     * to have the ".txt" extension
     * @param fileName string of the full file name.
     * @return true if longer than three
     */
    private static boolean validTxtExtensionSize(String fileName) {
        return (fileName.length() > 3);
    }

    /**
     * Checks if the file is a  text file
     * @param fileName string of the file name.
     * @return True if it ends with ".txt"
     */
    private static boolean isTxtFile(String fileName) {
        return fileName.substring(fileName.length() - 4, fileName.length()).matches(".txt");
    }

    /**
     * Checks if a file exists and is a file.
     * @param file The file to be checked
     */
    private static void checkFile(File file) {
        if (!file.exists() || !file.isFile()) {
            System.out.println("File doesn't exists or is not a file.");
            System.exit(0);
        }
    }

    /**
     * Prints out the full path of a given file.
     * @param file The file
     */
    private static void printFilePath(File file) {
        String path = file.getAbsolutePath();
        System.out.println("The file path is: " + path + "\n");
    }

    /**
     * Prints out the size of the file in bytes, kilobyts and megabyts.
     * @param file The file.
     */
    private static void calculateFileSize(File file) {
        long fileSize = file.length();
        double fileSizeKb = file.length() / 1024.0;
        double fileSizeMb = file.length() / (1024.0 * 1024.0);
        System.out.println("File size: " + fileSize + " bytes, " + 
                            fileSizeKb + "kb, " + fileSizeMb + "mb.\n");
    }

    /**
     * Prints out the frequency of the given word in the given file.
     * @param file File where we will search.
     * @param searchedWord The searched word.
     */
    private static void findWordFrequency(File file, String searchedWord) {
        try(Scanner scanner = new Scanner(file)){
            int wordFrequency = 0;
            String word;

            scanner.useDelimiter(DELIMITOR);
            
            while(scanner.hasNext()){
                word = scanner.next().toLowerCase();
                if(word.equals(searchedWord)){
                    wordFrequency++;
                };
            }

            System.out.println("The word: " + searchedWord + " occurs " + wordFrequency + " times.");
            scanner.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}