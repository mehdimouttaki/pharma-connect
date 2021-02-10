package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
}
