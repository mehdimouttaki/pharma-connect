package ma.pharmaconnect.app.pharmaconnect.processor;

import static java.util.stream.Collectors.toList;

import java.nio.file.Paths;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.pharmaconnect.app.pharmaconnect.dto.product.ProductCsvDto;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import ma.pharmaconnect.app.pharmaconnect.utils.ReaderCsvFile;
import ma.pharmaconnect.app.pharmaconnect.utils.ValidationCSVProducts;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProcessCsvProductToDb {

  private final ProductService  productService;


  public  void processProductToDb(String locationCsv){
    log.info("start processing csv file located in {}", locationCsv);
    List<ProductCsvDto> productCsvDtos = ReaderCsvFile
        .readCsv(Paths.get(locationCsv), ProductCsvDto.class);
    List<ProductCsvDto> validProductCsvDtos = getValidateProducts(productCsvDtos);
    List<ProductCsvDto> inValidProductCsvDtos = getInValidateProducts(productCsvDtos);
    showInvalidateProducts(inValidProductCsvDtos);
    List<Product> products = validProductCsvDtos.stream().map(this::map).collect(toList());

   // products.forEach(product -> log.info(product.toString()));
    productService.saveAll(products);
    log.info("end processing csv file to DB");
  }


  private List<ProductCsvDto> getValidateProducts( List<ProductCsvDto> productCsvDtos){
    return productCsvDtos.stream()
        .filter(ValidationCSVProducts::isPriceValid)
        .filter(ValidationCSVProducts::isPrescriptionValid).collect(
        toList());
  }

  private List<ProductCsvDto> getInValidateProducts(List<ProductCsvDto> productCsvDtos){
    return productCsvDtos.stream().filter(
        ValidationCSVProducts.not(ValidationCSVProducts::isPriceValid)).filter(
        ValidationCSVProducts.not(ValidationCSVProducts::isPrescriptionValid))
        .collect(toList());
  }

  private void showInvalidateProducts(List<ProductCsvDto> invalidproductCsvDtos){
    log.info("number of invalid line is {} ", invalidproductCsvDtos.size());
    invalidproductCsvDtos.forEach(productCsvDto -> log.info("invalid product {}",productCsvDto.toString()));
  }



  private Product map (ProductCsvDto productCsvDto){
    Product  product = new Product();
    product.setCode(productCsvDto.getCode());
    product.setName(productCsvDto.getName());
    product.setPrice(Double.parseDouble(productCsvDto.getPrice()));
    product.setPrescription("1" .equals(productCsvDto.getPrescription()));
    return product;
  }

}
