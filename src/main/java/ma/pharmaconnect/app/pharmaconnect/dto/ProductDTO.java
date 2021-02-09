package ma.pharmaconnect.app.pharmaconnect.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDTO {

    private Integer id;
    private String name;
    private Double price;
    private String code;
    private Boolean prescription;


}
