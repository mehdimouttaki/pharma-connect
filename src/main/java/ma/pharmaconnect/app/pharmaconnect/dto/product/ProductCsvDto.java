package ma.pharmaconnect.app.pharmaconnect.dto.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductCsvDto {

  private String name;
  private String code;
  private String prescription;
  private String price;

}
