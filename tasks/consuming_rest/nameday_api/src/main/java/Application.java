

import java.net.*;
import java.io.*;
import org.json.*;

/**
 * An application that utilizes the Nameday API
 */
public class Application {

    /**
     * Main program writes out the name day of sweden, denmark and usa
     * @param args ignored
     */
    public static void main(String[] args) {
        Country.stream()
                .forEach(country -> System.out.println("Todays nameday in " +
                        country.getFullName() + " is: " +
                        getTodaysNameday(country.getCode())));
    }

    /**
     * Gets the todays name day based on the country code!
     * @param country country code
     * @return nameday of given country
     */
    public static String getTodaysNameday(String country) {
        String nameday = "";
        JSONObject json = getRequestAPI("?country=" + country);
        if (json != null) {
            nameday = json.getJSONObject("data").getJSONObject("namedays").get(country).toString();
        }
        return nameday;
    }

    /**
     * Gets the todays nameday based on parameters!
     * @param params The parameters
     * @return Json result object
     */
    public static JSONObject getRequestAPI(String params) {
        JSONObject json = null;
        try {
            URL url = new URL("https://api.abalin.net/today" + params);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            if(con.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
                br.close();

                json = new JSONObject(content.toString());
            } else {
                System.out.println("Error");
                System.out.println("Server responded with: " + con.getResponseCode());
            }
        }
        catch(Exception ex){
            System.out.println("Something went wrong with the connection!");
        }
        return json;
    }
}
