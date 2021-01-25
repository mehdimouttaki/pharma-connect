package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


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
        return orderRepository.findById(id).get();
    }
}
