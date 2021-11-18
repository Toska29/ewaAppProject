package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.data.repositories.CustomerRepository;
import africa.semicolon.ewaApp.data.repositories.CustomerRepositoryImpl;
import africa.semicolon.ewaApp.dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerRegistrationResponse;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
private static final CustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        //convert request to customer
        Customer customer = new Customer();
        customer.setEmail(customerRegistrationRequest.getEmail());
        customer.setFirstName(customerRegistrationRequest.getFirstname());
        customer.setLastName(customerRegistrationRequest.getLastname());
        customer.setPassword(customerRegistrationRequest.getPassword());
        //save customer in repository
        Customer savedCustomer = customerRepository.addCustomer(customer);
        // convert save customer to response
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        response.setEmailAddress(savedCustomer.getEmail());
        response.setFirstname(savedCustomer.getFirstName());
        response.setLastname(savedCustomer.getLastName());

        return response;
    }

    @Override
    public CustomerRegistrationResponse loginCustomer(String emailAddress, String password) {
        CustomerRegistrationResponse response = new CustomerRegistrationResponse();
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer: customers) {
            if(customer.getPassword() == password && customer.getEmail() == emailAddress) {
                response.setEmailAddress(customer.getEmail());
                response.setLastname(customer.getLastName());
                response.setFirstname(customer.getFirstName());
                return response;
            }
        }
        return null;
    }
}
