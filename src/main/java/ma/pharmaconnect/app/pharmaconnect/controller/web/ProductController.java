package ma.pharmaconnect.app.pharmaconnect.controller.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @GetMapping("/products")
    public String allProducts() {
        return "/products/all_products";
    }
}
