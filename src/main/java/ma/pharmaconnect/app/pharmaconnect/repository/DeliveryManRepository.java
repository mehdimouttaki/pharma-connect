package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryManRepository extends CrudRepository<DeliveryMan, Integer> {
    @Modifying
    @Query("update DeliveryMan d set d.phone=:phone, d.firstName=:firstName," +
            " d.lastName=:lastName, d.username=:username where d.id=:id")
    void update(@Param("id") Integer id,
                       @Param("phone") String phone,
                       @Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("username") String username);
}
