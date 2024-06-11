package utils;

import ec.edu.espe.airlinereservationsystem.model.Customer;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CustomerManager {

    private List<Customer> customers;

    public CustomerManager() {
        this.customers = CustomerDataManager.loadCustomers(); // Load existing customers
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
}
