package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentDTO {

    private Integer id;
    private PaymentStatusDTO status;
    private PaymentMethodDTO method;


}