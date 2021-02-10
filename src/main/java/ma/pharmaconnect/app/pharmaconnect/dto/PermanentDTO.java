package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
public class PermanentDTO {

    private Integer id;
    private Date startDate;
    private Date endDate;
    private PermanentTypeDTO type;

    private List<PharmacyDTO> pharmacies;

}
