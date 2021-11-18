package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    private final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        for (Customer customer: customers) {
            if(customer.getEmail() == email) return customer;
        }
        return null;
    }

    @Override
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void removeCustomerByEmail(String email) {
        customers.remove(findCustomerByEmail(email));
    }
}
