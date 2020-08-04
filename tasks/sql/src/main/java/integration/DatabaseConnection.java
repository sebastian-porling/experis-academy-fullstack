package integration;

import model.*;
import java.sql.*;
import java.util.*;

/**
 * Handles all calls to the Chinook database
 */
public class DatabaseConnection {

    /**
     * Gets a customer with the given id
     * @param customerId integer
     * @return a customer or null of id doesn't exist
     */
    public Customer getCustomerById(int customerId) {
        String statement = "SELECT CustomerId, FirstName, LastName FROM Customer WHERE CustomerId = ?";
        PreparedStatement ps = null;
        try {
             ps = getConnection().prepareStatement(statement);
             ps.setInt(1, customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getCustomer(ps);
    }

    /**
     * Gets a random customer
     * @return a customer or null
     */
    public Customer getRandomCustomer() {
        String statement = "SELECT CustomerId, FirstName, LastName from Customer ORDER BY RANDOM() LIMIT 1";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getCustomer(ps);
    }

    /**
     * Gets a customer based on the prepared statement
     * @param ps prepared statement
     * @return a customer or null
     */
    private Customer getCustomer(PreparedStatement ps) {
        Customer customer = null;
        try{
            if (ps == null) {
                return null;
            }
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                customer = new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        getCustomerMostPopularGenre(rs.getInt("CustomerId"))
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    /**
     * Gets the customers favorite genres
     * @param customerId integer
     * @return list of genres
     */
    public List<Genre> getCustomerMostPopularGenre(int customerId) {
        String statement =  "SELECT Genre.GenreId, Genre.Name, COUNT(Genre.GenreId) as Occurrence FROM Genre " +
                                "INNER JOIN  (SELECT GenreId FROM Track WHERE TrackId IN " +
                                "(SELECT TrackId FROM InvoiceLine WHERE InvoiceId IN " +
                                "(SELECT InvoiceId FROM Invoice WHERE CustomerId = ?))) as T on Genre.GenreId = T.GenreId " +
                            "GROUP BY Genre.GenreId ORDER BY Occurrence DESC";
        List<Genre> genres = new ArrayList<>();
        try{
            PreparedStatement ps = getConnection().prepareStatement(statement);
            ps.setInt(1, customerId);
            int prevOccurrence = 0;
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int currentOccerrence = rs.getInt("Occurrence");
                if (currentOccerrence >= prevOccurrence) {
                    prevOccurrence = currentOccerrence;
                    genres.add(new Genre(rs.getInt("GenreId"), rs.getString("Name")));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return genres;
    }

    /**
     * Gets the totals sales between the star and end date
     * @param startDate string (yyyy-mm-dd)
     * @param endDate string (yyyy-mm-dd)
     * @return total sales
     */
    public Integer getTotalSales(String startDate, String endDate) {
        String statement =  "SELECT SUM(Total) as SumTotal FROM Invoice WHERE InvoiceDate >= date(?) and InvoiceDate <= date(?, '+1 day')";
        Integer sumTotal = 0;
        try {
            PreparedStatement ps = getConnection().prepareStatement(statement);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sumTotal = Math.toIntExact(Math.round(rs.getDouble("SumTotal")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sumTotal;
    }

    /**
     * Gets a connection to the database
     * @return sql connection
     */
    private Connection getConnection() {
        Connection connection = null;
        try {
            String DB_URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
