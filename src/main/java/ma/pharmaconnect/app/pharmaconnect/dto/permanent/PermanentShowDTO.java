package ma.pharmaconnect.app.pharmaconnect.dto.permanent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.pharmacy.PharmacyCreationDTO;

import java.util.Date;


@Getter
@Setter
@ToString
public class PermanentShowDTO {
    private Date startDate;
    private Date endDate;
    private PermanentTypeDTO type;
    private PharmacyCreationDTO name;
    private PharmacyCreationDTO pharmacy;
    private PharmacyCreationDTO address;

}
