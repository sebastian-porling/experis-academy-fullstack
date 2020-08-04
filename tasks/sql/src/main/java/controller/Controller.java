package controller;

import integration.DatabaseConnection;
import model.Customer;

/**
 * Controller handles all calls between view and model and integration
 */
public class Controller {
    private DatabaseConnection databaseConnection;

    /**
     * Constructor
     * @param databaseConnection database connection to the chinook database
     */
    public Controller(DatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }

    /**
     * Gets a customer by id
     * @param id customer id
     * @return a customer or null
     */
    public Customer getCustomerById(int id) {
        return databaseConnection.getCustomerById(id);
    }

    /**
     * Gets a random customer
     * @return a customer or null
     */
    public Customer getRandomCustomer() {
        return databaseConnection.getRandomCustomer();
    }

    /**
     * Gets the total sales between start date and end date
     * @param startDate string
     * @param endDate string
     * @return total sales
     */
    public Integer getTotalSalesBetweenDates(String startDate, String endDate) {
        return databaseConnection.getTotalSales(startDate, endDate);
    }
}
