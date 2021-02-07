package ma.pharmaconnect.app.pharmaconnect.DTO;

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
    private ClientDTO clientDTO;
    private DeliveryManDTO deliveryManDTO;
    private OrderDTO orderDTO;

}
