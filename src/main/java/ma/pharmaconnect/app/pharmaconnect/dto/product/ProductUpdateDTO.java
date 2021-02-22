package ma.pharmaconnect.app.pharmaconnect.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductUpdateDTO {
    private Integer id;
    private String name;
    private String code;
    private Boolean prescription;
    private Double price;
}
