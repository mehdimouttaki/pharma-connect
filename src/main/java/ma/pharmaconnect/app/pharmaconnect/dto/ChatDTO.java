package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManUpdateDTO;

import java.util.Date;


@Setter
@Getter
@ToString
public class ChatDTO {

    private Integer id;
    private String message;
    private Date createdAt;
    private ClientCreationDTO clientDTO;
    private DeliveryManUpdateDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
