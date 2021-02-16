package ma.pharmaconnect.app.pharmaconnect.dto.delivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryManCreationDTO {
    private String lastName;
    private String firstName;
    private String username;
    private String phone;
    private String password;
}
