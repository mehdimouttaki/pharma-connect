package ma.pharmaconnect.app.pharmaconnect.dto.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressCreationDTO {
    private String number;
    private String street;
    private String detail;
    private String city;
    private String zip;

    @Override
    public String toString() {
        return number + ", " + street + '\n' + detail + '\n' + zip + " " + city;
    }
}
