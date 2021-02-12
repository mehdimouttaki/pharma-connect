package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
public class ChatDTO {

    private Integer id;
    private String message;
    private Date createdAt;
    private ClientCreationDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
