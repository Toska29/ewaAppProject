package africa.semicolon.ewaApp.data.repositories;

import africa.semicolon.ewaApp.data.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    CustomerRepository customerRepository;
    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @Test
    void addCustomer() {
        Customer customer = new Customer();
        customer.setEmail("toska@gmail.com");
        customer.setFirstName("Tosin");
        customer.setLastName("Akinnusi");
        customer.setPassword("123456789");
        Customer savedCustomer = customerRepository.addCustomer(customer);
        assertEquals(customer, savedCustomer);
    }

    private Customer savedCustomerHelper(){
        Customer customer = new Customer();
        customer.setEmail("toska@gmail.com");
        customer.setFirstName("Tosin");
        customer.setLastName("Akinnusi");
        customer.setPassword("123456789");
        Customer savedCustomer = customerRepository.addCustomer(customer);
        return savedCustomer;
    }
    @Test
    void findAll() {
        Customer savedCustomerOne = savedCustomerHelper();
        Customer customerTwo = new Customer();
        customerTwo.setFirstName("Ahmad");
        customerTwo.setLastName("Ajala");
        customerTwo.setEmail("ahmad@gmail.com");
        customerTwo.setPassword("123456789");
        customerRepository.addCustomer(customerTwo);

        assertEquals(2, customerRepository.findAll().size());
    }

    @Test
    void findCustomerByEmail() {
        Customer savedCustomer = savedCustomerHelper();
        Customer foundCustomer = customerRepository.findCustomerByEmail("toska@gmail.com");

        assertEquals(savedCustomer, foundCustomer);
    }

    @Test
    void removeCustomer() {
        Customer customer = savedCustomerHelper();
        customerRepository.removeCustomer(customer);

        assertEquals(0, customerRepository.findAll().size());
    }

    @Test
    void removeCustomerByEmail() {
        Customer customer = savedCustomerHelper();
        customerRepository.removeCustomerByEmail("toska@gmail.com");

        assertEquals(0, customerRepository.findAll().size());
    }
}