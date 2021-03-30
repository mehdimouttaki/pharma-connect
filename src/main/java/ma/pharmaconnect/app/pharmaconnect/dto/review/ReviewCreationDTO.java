package ma.pharmaconnect.app.pharmaconnect.dto.review;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReviewCreationDTO {

    private String label;
    private Integer rate;
    private Integer deliveryManId;
    private Integer orderId;

}
