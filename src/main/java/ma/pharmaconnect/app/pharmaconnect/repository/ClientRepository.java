package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Optional<Client> findByUsername(String username);
}
