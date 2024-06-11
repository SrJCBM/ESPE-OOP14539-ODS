

package utils;
import ec.edu.espe.airlinereservationsystem.model.Customer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CustomerDataManager {
    private static final String CUSTOMER_DATA_FILE = "customers.json";

    public static void saveCustomers(List<Customer> customers) {
        JSONArray customerArray = new JSONArray();

        for (Customer customer : customers) {
            JSONObject customerJson = new JSONObject();
            customerJson.put("customerId", customer.getCustomerId());
            customerJson.put("name", customer.getName());
            customerJson.put("email", customer.getEmail());
            JSONArray ticketArray = new JSONArray();
            customerJson.put("ticketHistory", ticketArray);
            // Add other fields as necessary
            customerArray.put(customerJson);
        }

        try (FileWriter file = new FileWriter(CUSTOMER_DATA_FILE)) {
            file.write(customerArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> loadCustomers() {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_DATA_FILE))) {
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray customerArray = new JSONArray(jsonString.toString());

            for (int i = 0; i < customerArray.length(); i++) {
                JSONObject customerJson = customerArray.getJSONObject(i);
                int customerId = customerJson.getInt("customerId");
                String name = customerJson.getString("name");
                String email = customerJson.getString("email");
                Customer customer = new Customer(customerId, name, email);
                // Handle ticket history
                JSONArray ticketArray = customerJson.getJSONArray("ticketHistory");
                // Add logic to parse tickets and add to the customer's ticket history
                customers.add(customer);
            }

        } catch (FileNotFoundException e) {
            // No data file found, return an empty list
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
