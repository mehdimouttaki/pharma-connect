package ma.pharmaconnect.app.pharmaconnect.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricalAddressRepository extends CrudRepository<HistoricalAddressRepository,Integer> {
}
