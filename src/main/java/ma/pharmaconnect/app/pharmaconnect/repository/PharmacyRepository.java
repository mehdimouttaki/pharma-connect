package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends CrudRepository<Pharmacy, Integer> {
}
