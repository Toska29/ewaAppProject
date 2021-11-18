package africa.semicolon.ewaApp.controllers;

import africa.semicolon.ewaApp.dtos.requests.CustomerRegistrationRequest;
import africa.semicolon.ewaApp.dtos.responses.CustomerRegistrationResponse;
import africa.semicolon.ewaApp.services.CustomerService;
import africa.semicolon.ewaApp.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();

    @PostMapping("api/registerCustomer")
    public CustomerRegistrationResponse registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        return customerService.registerCustomer(customerRegistrationRequest);
    }

    @GetMapping("api/customer/{email}")
    public CustomerRegistrationResponse loginCustomer(@PathVariable("email") String email, String password){
        return customerService.loginCustomer(email, password);
    }
}
