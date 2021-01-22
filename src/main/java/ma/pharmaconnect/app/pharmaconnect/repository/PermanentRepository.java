package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentRepository extends CrudRepository<Permanent, Integer> {

    @Query(value = "SELECT * FROM permanent WHERE CURDATE() between permanent.start_date and permanent.end_date",nativeQuery = true)
    List<Permanent> getCurrentPermanent();
}
