package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> getAllByClientId(Integer clientId);

    @Query("select o from Order o where o.deliveryMan.id=:deliveryId or o.deliveryMan is null")
    List<Order> getAllByDeliveryId(@Param("deliveryId") Integer deliveryId);
}
