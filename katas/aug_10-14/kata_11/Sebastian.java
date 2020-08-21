import java.util.*;

public class Sebastian {
    public static int[] nums;

    /**
     * Main method
     * @param args Ignored arguments
     */
    public static void main(String[] args) {
        int[] test = {1, 3, 1, 4};
        int[] test2 = {1, 3, 1, 4, 4, 3, 1};
        int[] test3 = {3, 2, 2, 4};
        int[] userData = userInput();

        nums = (userData != null) && (userData.length > 1) ? userData : test2;
        System.out.println("original; " + Arrays.toString(nums));
        sortFoursAfterThrees();
        System.out.println("Sorted; " + Arrays.toString(nums));
    }

    /**
     * Gets the user input for the array to be sorted
     * @return
     */
    static int[] userInput() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter numbers seperated by 'enter'. Stop with 'q'.");
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.contains("q")) break;
            try {
                arr.add(Integer.parseInt(line));
            } catch (Exception e) {
                System.out.println("Not valid number, will use test data instead.");
                return null;
            }
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Puts a four after a three if it exists.
     */
    static void sortFoursAfterThrees() {
        int currentThree = findFirstThree();
        if(currentThree == -1) return;
        int sortedLength = 0;

        for (int i = 0; i < nums.length-1; i++) {

            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == 3){
                    currentThree = j;
                    break;
                }
            }

            for (int j = sortedLength; j < nums.length; j++) {
                if (nums[j] == 4 && j != currentThree+1) {
                    swap(j, currentThree+1);
                    sortedLength = j;
                    break;
                }
            }
        }
    }

    /**
     * Finds the first three in the array
     * @return returns position or -1
     */
    static int findFirstThree() {
        int currentThree = 0;
        int k = 0;
        while (currentThree != 0) {
            if (k >= nums.length) return -1;
            if(nums[k] == 3) {
                currentThree=k;
            }
        }
        return currentThree;
    }

    /**
     * Swaps two elements in the array
     */
    static void swap(int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

