package ma.pharmaconnect.app.pharmaconnect.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;




@Setter
@Getter
@ToString

public class UserDTO {

    protected Integer id;
    protected String lastName;
    protected String firstName;
    protected String username;
    protected String password;
    protected UserRoleDTO role;

}
