package africa.semicolon.ewaApp.dtos.requests;

import lombok.Data;

@Data
public class CustomerRegistrationRequest {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
}
