package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Integer> {
    @Query("select p from Pharmacy p where p.city.label=:city")
    List<Pharmacy> findAllByCityLabel(@Param("city") String city);
}
