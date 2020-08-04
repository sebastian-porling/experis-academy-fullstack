package view;

import controller.Controller;
import model.Customer;
import java.util.Scanner;

/**
 * View takes in all the user input and prints out the result in the console
 */
public class View {
    private final Controller controller;
    private final Scanner scanner;

    /**
     * Constructor
     * @param controller controller
     */
    public View(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     *  The "main" program.
     */
    public void start(){
        int id = getCustomerIdFromUser();
        Customer customer;
        if (id == 0) {
            customer = controller.getRandomCustomer();
        } else {
            customer = controller.getCustomerById(id);
        }
        printCustomerInfo(customer);
        String[] dateInterval = getDatesFromUser();
        Integer totalSales = controller.getTotalSalesBetweenDates(dateInterval[0], dateInterval[1]);
        printTotalSales(dateInterval, totalSales);
        scanner.close();
    }

    /**
     * Prints out the total sales in the date interval
     * @param dateInterval string array with two dates
     * @param totalSales integer
     */
    private void printTotalSales(String[] dateInterval, Integer totalSales) {
        System.out.println("\nThe total sales between " + dateInterval[0] + " and " + dateInterval[1] + " is:");
        System.out.println(totalSales + "\n");
    }

    /**
     * Prints out the customer name and most popular genres
     * @param customer the customer
     */
    private void printCustomerInfo(Customer customer) {
        if (customer != null) {
            System.out.println("\nThe customer " + customer.getFullName() + " favorite genres are: ");
            customer.getMostPopularGenres().forEach(System.out::println);
        } else {
            System.out.println("That user doesn't exist!");
        }
    }

    /**
     * Gets a date interval from the user using standard input
     * @return date interval
     */
    private String[] getDatesFromUser() {
        String[] dateInterval;
        try {
            System.out.println("\nStarting date (yyyy-mm-dd): ");
            String startDate = scanner.nextLine();
            System.out.println("\nEnding date (yyyy-mm-dd): ");
            String endDate = scanner.nextLine();
            dateInterval = new String[]{startDate, endDate};
            if (!validDate(startDate) || !validDate(endDate)){
                System.out.println("One or both of the dates are incorrect, try again!");
                dateInterval = getDatesFromUser();
            }
        } catch (Exception e) {
            dateInterval = getDatesFromUser();
        }
        return dateInterval;
    }

    /**
     * Checks of the string is a valid date
     * @param date date as string with the format (yyyy-mm-dd)
     * @return true if correct format
     */
    private boolean validDate(String date) {
        return date.matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
    }

    /**
     * Gets the customer id from the user using standard input
     * @return customer id
     */
    private int getCustomerIdFromUser() {
        int id = 0;
        try {
            System.out.println("Enter Customer Id: ");
            id = Integer.parseInt(scanner.nextLine());

        } catch(Exception e) {
            System.out.println("Not valid id, we will give you a random customer!");
        }
        return id;
    }

}