package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.Order;
import ma.pharmaconnect.app.pharmaconnect.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public String allOrder(Model model) {
        List<Order> list = orderService.getAll();
        model.addAttribute("orders", list);
        return "/orders/all_orders";
    }
}
