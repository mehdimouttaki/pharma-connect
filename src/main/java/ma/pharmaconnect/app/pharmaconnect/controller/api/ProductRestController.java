package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }
}
