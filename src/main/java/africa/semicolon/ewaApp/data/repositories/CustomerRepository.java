package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer addCustomer(Customer customer);
    List<Customer> findAll();
    Customer findCustomerByEmail(String email);
    void removeCustomer(Customer customer);
    void removeCustomerByEmail(String email);

}
