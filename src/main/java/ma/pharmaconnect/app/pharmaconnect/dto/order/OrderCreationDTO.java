package ma.pharmaconnect.app.pharmaconnect.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderCreationDTO {

    private String nameProduct;
    private Integer nbrProduct;
    private Double price;

}
