package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;


import java.util.Date;

@Setter
@Getter
@ToString
public class HistoricalAddressDTO {

    private Integer id;
    private String address;
    private Date lastModifiedDate;
    private ClientCreationDTO clientDTO;

}
