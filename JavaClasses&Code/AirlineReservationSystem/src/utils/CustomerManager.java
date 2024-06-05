
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
        this.customers = new ArrayList<>();
    }

    public Customer createCustomer(String name, String email) {
        int customerId = customers.size() + 1;
        Customer customer = new Customer(customerId, name, email);
        customers.add(customer);
        return customer;
    }

    public Customer getCustomer(int id) {
        return customers.get(id - 1);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
