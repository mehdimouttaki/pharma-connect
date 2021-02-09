package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

@Setter
@Getter
@ToString
public class HistoricalAddressDTO {

    private Integer id;
    private String address;
    private Date lastModifiedDate;
    private ClientDTO clientDTO;

}

