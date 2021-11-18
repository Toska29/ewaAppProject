package africa.semicolon.ewaApp.dtos.responses;

import lombok.Data;

@Data
public class CustomerRegistrationResponse {
    private String emailAddress;
    private String firstname;
    private String lastname;
}
