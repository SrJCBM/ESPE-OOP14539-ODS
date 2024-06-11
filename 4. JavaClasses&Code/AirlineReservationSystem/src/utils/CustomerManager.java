
package utils;

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
        customers = CustomerDataManager.loadCustomers();
    }

    public Customer createCustomer(String name, String email) {
        int customerId = customers.size() + 1; // Simple ID generation
        Customer customer = new Customer(customerId, name, email);
        customers.add(customer);
        CustomerDataManager.saveCustomers(customers);
        return customer;
    }

    public Customer getCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        throw new IndexOutOfBoundsException("Customer not found");
    }
    
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
