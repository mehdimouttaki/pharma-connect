package ma.pharmaconnect.app.pharmaconnect.dto.delivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.UserRoleDTO;

@Setter
@Getter
@ToString

public class DeliveryManUpdateDTO {
    private Integer id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private UserRoleDTO role;
    private String phone;
}
