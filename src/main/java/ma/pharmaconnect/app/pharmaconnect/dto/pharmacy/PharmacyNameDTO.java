package ma.pharmaconnect.app.pharmaconnect.dto.pharmacy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PharmacyNameDTO {
    private Integer id;
    private String name;
    private String address;

}
