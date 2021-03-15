package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.repository.ClientRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static ma.pharmaconnect.app.pharmaconnect.model.OrderStatus.ATTACHED_TO_DELIVERY;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ClientRepository clientRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return (List<Order>) orderRepository.findAll();
    }

    public Order getOne(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order", id));

    }

    public Client update(Client client) {
        return clientRepository.save(client);
    }

    public List<Order> getAllByClientId(Integer clientId) {
        return orderRepository.getAllByClientId(clientId);
    }

    public List<Order> getAllByDeliveryId(Integer deliveryId) {
        return orderRepository.getAllByDeliveryId(deliveryId);
    }

    @Transactional
    public void deliveryTakeOrder(Integer deliveryId, Integer orderId) {
        orderRepository.deliveryTakeOrder(deliveryId, ATTACHED_TO_DELIVERY , orderId);
    }
}
