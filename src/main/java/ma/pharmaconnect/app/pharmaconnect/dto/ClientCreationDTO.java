package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientCreationDTO {
    private String lastName;
    private String firstName;
    private String username;
    private String phone;
    private String password;
}
