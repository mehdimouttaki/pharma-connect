package ma.pharmaconnect.app.pharmaconnect.dto.chat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.OrderDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManUpdateDTO;

import java.util.Date;


@Setter
@Getter
@ToString
public class ChatCreationDTO {

    private Integer id;
    private String message;
    private Date createdAt;
    private ClientCreationDTO clientDTO;
    private DeliveryManUpdateDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
