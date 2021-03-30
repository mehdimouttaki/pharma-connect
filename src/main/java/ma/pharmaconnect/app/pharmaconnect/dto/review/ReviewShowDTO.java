package ma.pharmaconnect.app.pharmaconnect.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientShowDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManShowDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderShowDTO;

@Getter
@Setter
@ToString
public class ReviewShowDTO {
    private Integer id;
    private String label;
    private Integer rate;
    private ClientShowDTO client;
    private DeliveryManShowDTO deliveryMan;
    private OrderShowDTO order;
}
