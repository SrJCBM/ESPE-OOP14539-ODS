package ec.edu.espe.airlinereservationsystem.utils;

import org.json.JSONArray;
import ec.edu.espe.airlinereservationsystem.model.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kerlly Chiriboga - ODS
 */
public class JsonUtils {

    private static CustomerManager customerManager = new CustomerManager();
    private static FlightManager flightManager = new FlightManager();

    public static void saveCustomersToFile(List<Customer> customers, String filename) {
        JSONArray jsonArray = new JSONArray();
        for (Customer customer : customers) {
            jsonArray.put(customer.toJSON());
        }
        try {
            String jsonString = jsonArray.toString(4);
            Files.write(Paths.get(filename), jsonString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> loadCustomersFromFile(String filename) {
        List<Customer> customers = new ArrayList<>();
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filename));
            String content = new String(bytes);
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                customers.add(Customer.fromJSON(jsonArray.getJSONObject(i), customerManager, flightManager));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
