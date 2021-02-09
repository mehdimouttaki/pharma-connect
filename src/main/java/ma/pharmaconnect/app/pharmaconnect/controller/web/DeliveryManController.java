package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.service.DeliveryManService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeliveryManController {

    private final  DeliveryManService deliveryManService;

    @GetMapping("/delivery-men/add")
    public String addDeliveryMan() {
        return "/delivery_men/add_delivery_men";
    }

    @GetMapping("/delivery-men")
    public String allDeliveryMan(Model model) {
        List<DeliveryMan> list = deliveryManService.getAll();
        model.addAttribute("deliveryMen", list);
        return "/delivery_men/all_delivery_men";
    }

    @GetMapping("/delivery-men/edit")
    public String editDeliveryMan() {
        return "/delivery_men/edit_delivery_men";
    }

    @PostMapping("/delivery-men/add")
    public String saveDeliveryMan(DeliveryMan deliveryMan) {
        deliveryManService.save(deliveryMan);
        return "redirect:/delivery-men";
    }

    @GetMapping("/delivery-men/delete/{id}")
    public String deleteDeliveryMan(@PathVariable Integer id) {
        deliveryManService.delete(id);
        return "redirect:/delivery-men";
    }
    @GetMapping("delivery-men/review/{id}")
    public String OneDeliveryMan() {
        return "/delivery_men/view_delivery_men";
    }

}
