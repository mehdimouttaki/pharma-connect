package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.delete(id);
    }

    @PutMapping("/api/products")
    public  Product updateProduct(@RequestBody Product product) {
        return productService.update(product);
    }
}
