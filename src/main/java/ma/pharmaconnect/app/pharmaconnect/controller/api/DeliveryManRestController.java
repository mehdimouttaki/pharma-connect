package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.service.DeliveryManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryManRestController {
    @Autowired
    private DeliveryManService deliveryManService;


    @PutMapping("/api/delivery-men")
    public  DeliveryMan updateDeliveryMan(@RequestBody DeliveryMan deliveryMan) {
        return deliveryManService.update(deliveryMan);
    }

}
