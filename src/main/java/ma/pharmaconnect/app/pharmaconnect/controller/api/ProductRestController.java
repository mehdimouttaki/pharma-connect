package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getAll(@RequestParam("q") String q) {
        if (ObjectUtils.isEmpty(q)) {
            return Collections.emptyList();
        }

        return productService.search(q);
    }

    @GetMapping("/api/products/{id}")
    public Product getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }
}
