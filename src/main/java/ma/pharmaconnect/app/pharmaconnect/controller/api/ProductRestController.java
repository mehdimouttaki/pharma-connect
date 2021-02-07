package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/api/products/{id}")
    public Product getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }
}
