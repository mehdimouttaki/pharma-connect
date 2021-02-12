package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;

@Setter
@Getter
@ToString
public class OrderDTO {

    private Integer id;
    private Integer nbrProduct;
    private Double price;
    private ClientCreationDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private PharmacyDTO pharmacyDTO;

}
