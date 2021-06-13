package ma.pharmaconnect.app.pharmaconnect.utils;

import java.util.function.Predicate;
import ma.pharmaconnect.app.pharmaconnect.dto.product.ProductCsvDto;

public class ValidationCSVProducts {

  public static <T> Predicate<T> not(Predicate<T> t) {
    return t.negate();
  }

  public static boolean isPriceValid(ProductCsvDto productCsvDto){
    try {
      Double.parseDouble(productCsvDto.getPrice());
      return true;
    }
    catch (NumberFormatException ex){
      return  false;
    }
  }

  public static boolean isPrescriptionValid(ProductCsvDto productCsvDto){
    return  "0" .equals(productCsvDto.getPrescription()) || "1"
        .equals(productCsvDto.getPrescription());
  }

}
