package ma.pharmaconnect.app.pharmaconnect.controller.web;



import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.product.ProductCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.product.ProductUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products/add")
    public String addProduct() {
        return "/products/add_products";
    }
    @PostMapping("/products/add")
    public String saveProduct(ProductCreationDTO productDTO) {
        Product product=new ModelMapper().map(productDTO,Product.class);
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/products")
    public String allProduct(Model model) {
        List<Product> list = productService.getAll();
        model.addAttribute("products", list);
        return "/products/all_products";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model, @PathVariable Integer id) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        return "/products/edit_products";
    }

    @PostMapping("/products/edit")
    public String updateProduct(ProductUpdateDTO productDTO) {
        Product product = new ModelMapper().map(productDTO, Product.class);
        productService.save(product);
        return "redirect:/products";
    }
    @GetMapping("/products/view/{id}")
    public String oneProduct(@PathVariable Integer id, Model model) {
        Product product = productService.getOne(id);
        model.addAttribute("product", product);
        return "/products/view_products";
    }
}
