package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReviewDTO {

    private Integer id;
    private String review;
    private Integer rate;
    private ClientDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
