package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryManController {

    @GetMapping("/delivery-men/add")
    public String addDeliveryMan() {
        return "add_delivery_men";
    }

    @GetMapping("/delivery-men")
    public String allDeliveryMan() {
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
