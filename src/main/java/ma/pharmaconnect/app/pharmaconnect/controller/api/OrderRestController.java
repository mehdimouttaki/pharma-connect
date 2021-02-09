package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/orders")
    public Order addOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/api/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
    }

    @PutMapping("/api/orders")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @GetMapping("/api/orders")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/api/orders/{id}")
    public Order getOne(@PathVariable Integer id) {
        return orderService.getOne(id);
    }
}
