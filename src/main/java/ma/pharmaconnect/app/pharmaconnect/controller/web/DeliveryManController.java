package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DeliveryManController {
    @Autowired
    private DeliveryManService deliveryManService;

    @GetMapping("/delivery-men/add")
    public String addDeliveryMan() {
        return "add_delivery_men";
    }

    @GetMapping("/delivery-men")
    public String allDeliveryMan(Model model) {
        List<DeliveryMan> list = deliveryManService.getAll();
        model.addAttribute("deliveryMen", list);
        return "all_delivery_men";
    }

    @GetMapping("/delivery-men/edit")
    public String editDeliveryMan() {
        return "edit_delivery_men";
    }

    @GetMapping("/delivery-men/delete")
    public String deleteDeliveryMan() {
        return "delete_delivery_men";
    }
}
