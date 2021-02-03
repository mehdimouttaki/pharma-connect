package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.*;
import ma.pharmaconnect.app.pharmaconnect.repository.ClientRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;


    public Order save(Order order) {


        Client client = clientRepository.findById(order.getClient().getId()).orElseThrow(NoSuchElementException::new);
        order.setClient(client);



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
        return orderRepository.findById(id).get();
    }
    public Client update(Client client) {

        return clientRepository.save(client);
    }
}
