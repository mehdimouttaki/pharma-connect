package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class DeliveryManDTO {
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private UserRoleDTO role;
    private String phone;
}
