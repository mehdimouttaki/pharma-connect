package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.service.DetailOrderService;
import ma.pharmaconnect.app.pharmaconnect.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final DetailOrderService detailOrderService;

    @GetMapping("/orders")
    public String allOrder(Model model) {
        List<Order> list = orderService.getAll();
        model.addAttribute("orders", list);
        return "/orders/all_orders";
    }

    @GetMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @GetMapping("/orders/view/{id}")
    public String oneOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderService.getOne(id));
        model.addAttribute("orderDetails", detailOrderService.getByOrder(id));
        return "/orders/view_orders";
    }
}
