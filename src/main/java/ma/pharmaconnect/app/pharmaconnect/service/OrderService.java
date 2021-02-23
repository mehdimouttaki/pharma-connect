package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.repository.ClientRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ClientRepository clientRepository;

    private final ProductRepository productRepository;

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
}
