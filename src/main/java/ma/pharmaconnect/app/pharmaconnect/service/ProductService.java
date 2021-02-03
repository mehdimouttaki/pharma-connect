package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.Product;
import ma.pharmaconnect.app.pharmaconnect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

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
