package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.product.ProductShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/api/products")
    public List<ProductShowDTO> getAll(@RequestParam("q") String q) {
        if (ObjectUtils.isEmpty(q) && q.length() <= 1) {
            return Collections.emptyList();
        }

        return productService.search(q)
                .stream()
                .map(p -> new ModelMapper().map(p, ProductShowDTO.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/api/products/{id}")
    public Product getOne(@PathVariable Integer id) {
        return productService.getOne(id);
    }
}
