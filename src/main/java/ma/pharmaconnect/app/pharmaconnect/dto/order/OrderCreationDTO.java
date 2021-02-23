package ma.pharmaconnect.app.pharmaconnect.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
public class OrderCreationDTO {

    private List<String> codes = new ArrayList<>();
    private String deliveryAddress;

}
