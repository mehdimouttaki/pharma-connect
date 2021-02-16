package ma.pharmaconnect.app.pharmaconnect.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderCreationDTO;

@Setter
@Getter
@ToString
public class ReviewCreationDTO {

    private Integer id;
    private String review;
    private Integer rate;
    private ClientCreationDTO clientDTO;
    private DeliveryManUpdateDTO deliveryManDTO;
    private OrderCreationDTO orderCreationDTO;

}
