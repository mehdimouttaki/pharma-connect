package ma.pharmaconnect.app.pharmaconnect.repository;

import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.model.OrderStatus;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("update Order o set o.deliveryMan.id=:deliveryId, o.orderStatus=:status where o.id=:orderId")
    void deliveryTakeOrder(@Param("deliveryId") Integer deliveryId, @Param("status") OrderStatus status, @Param("orderId") Integer orderId);

    @Modifying
    @Query("update Order o set o.orderStatus=:status where o.id=:orderId")
    void changeStatus(@Param("status") OrderStatus status, @Param("orderId") Integer orderId);
}
