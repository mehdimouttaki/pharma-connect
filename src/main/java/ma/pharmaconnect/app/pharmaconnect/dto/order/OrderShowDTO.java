package ma.pharmaconnect.app.pharmaconnect.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;


import java.util.Date;

@Getter
@Setter
@ToString
public class OrderShowDTO {
    private String nameProduct;
    private Integer nbrProduct;
    private Double price;
    private ClientCreationDTO clientDTO;
    private Date timeOrder;

}
