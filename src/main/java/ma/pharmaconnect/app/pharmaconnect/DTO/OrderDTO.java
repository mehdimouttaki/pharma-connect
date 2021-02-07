package ma.pharmaconnect.app.pharmaconnect.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;





@Setter
@Getter
@ToString
public class OrderDTO {

    private Integer id;
    private Integer nbrProduct;
    private Double price;
    private ClientDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private PharmacyDTO pharmacyDTO;

}
