package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query("select p from Product p where p.code like %:q% or p.name like %:q%")
    List<Product> search(@Param("q") String q);
}
