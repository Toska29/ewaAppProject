package africa.semicolon.ewaApp.services;

import africa.semicolon.ewaApp.data.models.Customer;
import africa.semicolon.ewaApp.dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerRegistrationResponse;

public interface CustomerService {
    CustomerRegistrationResponse registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
    CustomerRegistrationResponse loginCustomer(String emailAddress, String Password);
}
