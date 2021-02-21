package ma.pharmaconnect.app.pharmaconnect.dto.pharmacy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PharmacyUpdateDTO {
    private Integer id;
    private String name;
    private String address;
    private String pharmacist;
    private Double lat;
    private Double lng;
}
