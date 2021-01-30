package ma.pharmaconnect.app.pharmaconnect.controller.web;


import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public String allProduct(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("products", list);
        return "/products/all_products";
    }
    @PostMapping("/products/add")
    public String saveProduct(Product product) {
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }
}
