package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.order.OrderShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.DetailOrder;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.model.Payment;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import ma.pharmaconnect.app.pharmaconnect.service.DetailOrderService;
import ma.pharmaconnect.app.pharmaconnect.service.OrderService;
import ma.pharmaconnect.app.pharmaconnect.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static ma.pharmaconnect.app.pharmaconnect.model.PaymentMethod.CASH;
import static ma.pharmaconnect.app.pharmaconnect.model.PaymentStatus.NOT_PAYED;

@RestController
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final DetailOrderService detailOrderService;
    private final PaymentService paymentService;

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
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/api/orders/{id}")
    public Order getOne(@PathVariable Integer id) {
        return orderService.getOne(id);
    }
}
