package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;

@Setter
@Getter
@ToString
public class ReviewDTO {

    private Integer id;
    private String review;
    private Integer rate;
    private ClientCreationDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
