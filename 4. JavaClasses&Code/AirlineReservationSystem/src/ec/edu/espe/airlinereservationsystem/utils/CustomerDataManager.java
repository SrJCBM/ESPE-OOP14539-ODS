package ec.edu.espe.airlinereservationsystem.utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import ec.edu.espe.airlinereservationsystem.model.Ticket;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataManager {

    private static final String CUSTOMER_DATA_FILE = "customers.json";
    private static ReservationSystem reservationSystemInt;

    public static void setReservationSystem(ReservationSystem reservationSystem) {
        reservationSystemInt = reservationSystem;
    }

    public static void saveCustomers(List<Customer> customers) {
        JSONArray customerArray = new JSONArray();

        for (Customer customer : customers) {
            JSONObject customerJson = customer.toJSON();
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
                Customer customer = Customer.fromJSON(customerJson, reservationSystemInt.getCustomerManager(), reservationSystemInt.getFlightManager());
                customers.add(customer);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Customer data file not found, creating a new one upon first save.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
