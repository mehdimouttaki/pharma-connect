package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/api/orders")
    public Order addOrder(@RequestBody OrderCreationDTO orderDto) {
       Order order = new ModelMapper().map(orderDto,Order.class);
       Order orderSaved=orderService.save(order);
       return new ModelMapper().map(orderSaved, (Type) OrderShowDTO.class);
    }

    @DeleteMapping("/api/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
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
