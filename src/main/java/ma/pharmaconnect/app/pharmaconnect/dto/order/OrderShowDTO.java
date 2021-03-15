package ma.pharmaconnect.app.pharmaconnect.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientShowDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.OrderStatus;

@Getter
@Setter
@ToString
public class OrderShowDTO {
    private Integer id;
    private Double price;
    private String address;
    private ClientShowDTO client;
    private DeliveryManShowDTO deliveryMan;
    private OrderStatus orderStatus;

}
