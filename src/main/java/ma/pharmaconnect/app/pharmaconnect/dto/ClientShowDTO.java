package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class ClientShowDTO {
    private Integer id;
    private String lastName;
    private String firstName;
    private String username;
    private String phone;
    private UserRoleDTO role;
    private Date createdAt;
    private String status;
}
