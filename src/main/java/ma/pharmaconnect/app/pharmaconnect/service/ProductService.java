package ma.pharmaconnect.app.pharmaconnect.service;


import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
    public Product update(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();

    }

    public Product getOne(Integer id) {

        return productRepository.findById(id).get();
    }
}
