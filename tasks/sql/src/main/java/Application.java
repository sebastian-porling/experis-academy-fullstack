import controller.Controller;
import integration.DatabaseConnection;
import view.View;

/**
 * This application gets customer information and total sales between two dates
 */
public class Application {

    /**
     * Main startup method
     * @param args ignored
     */
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Controller controller = new Controller(databaseConnection);
        View view = new View(controller);
        view.start();
    }
}
