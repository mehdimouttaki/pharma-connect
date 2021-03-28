package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.model.User;
import ma.pharmaconnect.app.pharmaconnect.repository.ClientRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static ma.pharmaconnect.app.pharmaconnect.model.OrderStatus.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ChatService chatService;

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
    public void deliveryTakeOrder(DeliveryMan deliveryMan, Integer orderId) {
        Order order = getOne(orderId);
        orderRepository.deliveryTakeOrder(deliveryMan.getId(), ATTACHED_TO_DELIVERY, orderId);
        chatService.createChat(order, deliveryMan, String.format("Order '#%s' is taken by '%s'", order.getId(), deliveryMan.getFirstName()));
    }

    @Transactional
    public void deliveryIsDelivering(DeliveryMan deliveryMan, Integer orderId) {
        Order order = getOne(orderId);
        orderRepository.changeStatus(DELIVERING, orderId);
        chatService.createChat(order, deliveryMan, String.format("Order '#%s' is now delivering by '%s'", order.getId(), deliveryMan.getFirstName()));
    }

    @Transactional
    public void orderIsDelivered(User user, Integer orderId) {
        Order order = getOne(orderId);
        orderRepository.changeStatus(DONE, orderId);
        chatService.createChat(order, order.getDeliveryMan(), String.format("Order '#%s' is now delivered by '%s'", order.getId(), order.getDeliveryMan().getFirstName()));
    }
}
