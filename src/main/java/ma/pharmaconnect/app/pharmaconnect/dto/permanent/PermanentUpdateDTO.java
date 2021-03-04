package ma.pharmaconnect.app.pharmaconnect.dto.permanent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.pharmacy.PharmacyNameDTO;

@Getter
@Setter
@ToString
public class PermanentUpdateDTO {

    private Integer id;
    private String rangeDate;
    private String type;

}
