package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {
    CustomerService customerService;
    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImpl();

    }

    @Test
    void registerCustomer() {
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setEmail("toska@gmail.com");
        customerRegistrationRequest.setFirstname("Tosin");
        customerRegistrationRequest.setLastname("Akinnusi");
        customerRegistrationRequest.setPassword("123456789");

        CustomerRegistrationResponse response = customerService.registerCustomer(customerRegistrationRequest);

        assertEquals("Tosin", response.getFirstname());

    }

    @Test
    void loginCustomer() {
        CustomerRegistrationRequest customerRegistrationRequest = new CustomerRegistrationRequest();
        customerRegistrationRequest.setEmail("toska@gmail.com");
        customerRegistrationRequest.setFirstname("Tosin");
        customerRegistrationRequest.setLastname("Akinnusi");
        customerRegistrationRequest.setPassword("123456789");

        CustomerRegistrationResponse response = customerService.registerCustomer(customerRegistrationRequest);

        CustomerRegistrationResponse loginCustomer = customerService.loginCustomer("toska@gmail.com", "123456789");

        assertEquals(response, loginCustomer);
    }
}