package ma.pharmaconnect.app.pharmaconnect.dto.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentCreationDTO {

    private PaymentStatusDTO status;
    private PaymentMethodDTO method;


}
