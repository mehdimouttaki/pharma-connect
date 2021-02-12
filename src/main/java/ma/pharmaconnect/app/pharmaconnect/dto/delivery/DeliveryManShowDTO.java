package ma.pharmaconnect.app.pharmaconnect.dto.delivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.UserRoleDTO;

import java.util.Date;

@Setter
@Getter
@ToString
public class DeliveryManShowDTO {
    private Integer id;
    private String lastName;
    private String firstName;
    private String username;
    private String phone;
    private UserRoleDTO role;
    private Date createdAt;
    private String status;
}
