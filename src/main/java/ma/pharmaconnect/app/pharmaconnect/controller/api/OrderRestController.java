package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.*;
import ma.pharmaconnect.app.pharmaconnect.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ma.pharmaconnect.app.pharmaconnect.model.PaymentMethod.CASH;
import static ma.pharmaconnect.app.pharmaconnect.model.PaymentStatus.NOT_PAYED;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryManService deliveryManService;
    private final DetailOrderService detailOrderService;
    private final PaymentService paymentService;
    private final UserService userService;

    @PostMapping("/api/orders")
    public OrderShowDTO addOrder(@RequestBody OrderCreationDTO orderDto, @RequestHeader("username") String username) {

        Client client = clientService.getByUsername(username);

        Order order = new Order();
        order.setPrice(0.0);
        order.setClient(client);
        order.setAddress(orderDto.getDeliveryAddress());
        Order orderSaved = orderService.save(order);


        List<DetailOrder> detailOrders = orderDto.getCodes().stream().map(code -> {
            DetailOrder detailOrder = new DetailOrder();
            detailOrder.setProductCode(code);
            detailOrder.setNbrProduct(1);
            detailOrder.setOrder(orderSaved);
            return detailOrder;
        }).collect(Collectors.toList());

        detailOrderService.saveAll(detailOrders);

        Payment payment = new Payment().setOrder(order).setMethod(CASH).setStatus(NOT_PAYED);
        paymentService.add(payment);

        return new ModelMapper().map(orderSaved, OrderShowDTO.class);
    }

    @DeleteMapping("/api/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
    }


    @GetMapping("/api/orders")
    public List<OrderShowDTO> getAll(@RequestHeader("username") String username) {
        User user = userService.getByUsername(username);
        List<Order> orders = new ArrayList<>();
        if (user.getRole().equals(UserRole.DELIVERY)) {
            orders = orderService.getAllByDeliveryId(user.getId());
        } else if (user.getRole().equals(UserRole.CLIENT)) {
            orders = orderService.getAllByClientId(user.getId());
        }

        List<OrderShowDTO> dtoList = orders
                .stream()
                .map(order -> new ModelMapper().map(order, OrderShowDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @GetMapping("/api/orders/{id}")
    public Order getOne(@PathVariable Integer id) {
        return orderService.getOne(id);
    }

    @GetMapping("/api/orders/take-it/{orderId}")
    public void deliveryTakeOrder(@PathVariable Integer orderId, @RequestHeader("username") String username) {
        DeliveryMan deliveryMan = deliveryManService.getByUsername(username);

        orderService.deliveryTakeOrder(deliveryMan, orderId);
    }
}
