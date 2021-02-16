package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderCreationDTO;

@Setter
@Getter
@ToString
public class DetailOrderDTO {

    private Integer id;
    private String productCode;
    private OrderCreationDTO orderCreationDTO;

}
