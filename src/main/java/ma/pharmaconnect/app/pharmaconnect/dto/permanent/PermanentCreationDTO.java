package ma.pharmaconnect.app.pharmaconnect.dto.permanent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.pharmacy.PharmacyCreationDTO;


import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
public class PermanentCreationDTO {

    private Date startDate;
    private Date endDate;
    private PermanentTypeDTO type;
    private List<PharmacyCreationDTO> pharmacies;

}
