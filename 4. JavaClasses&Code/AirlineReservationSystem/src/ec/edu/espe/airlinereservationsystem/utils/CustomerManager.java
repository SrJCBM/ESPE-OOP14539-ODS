package ec.edu.espe.airlinereservationsystem.utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CustomerManager {

    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
        loadCustomers();
    }

    public void loadCustomers() {
         List<Customer> loadedCustomers = CustomerDataManager.loadCustomers();
    if (loadedCustomers != null) {
        this.customers = loadedCustomers;
        System.out.println("Customers loaded: " + customers.size());
    } else {
        System.out.println("Failed to load customers.");
    }
}

    public Customer createCustomer(String name, String email) {
        int customerId = customers.size() + 1; // Generate unique IDs
        Customer customer = new Customer(customerId, name, email);
        customers.add(customer);
        CustomerDataManager.saveCustomers(customers); // Save to file
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }
    public Customer getCustomerByUsername(String username) {
    for (Customer customer : customers) {
        if (customer.getUsername().equals(username)) {
            return customer;
        }
    }
    return null;
}
}
