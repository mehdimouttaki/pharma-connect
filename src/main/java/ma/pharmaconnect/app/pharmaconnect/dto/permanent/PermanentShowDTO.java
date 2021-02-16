package ma.pharmaconnect.app.pharmaconnect.dto.permanent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.PharmacyDTO;

import java.util.Date;


@Getter
@Setter
@ToString
public class PermanentShowDTO {
    private Date startDate;
    private Date endDate;
    private PermanentTypeDTO type;
    private PharmacyDTO name;
    private PharmacyDTO pharmacy;
    private  PharmacyDTO address;

}
