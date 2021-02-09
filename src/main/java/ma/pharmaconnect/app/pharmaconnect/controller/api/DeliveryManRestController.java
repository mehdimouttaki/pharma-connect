package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.service.DeliveryManService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeliveryManRestController {

    private final DeliveryManService deliveryManService;

    @PutMapping("/api/delivery-men")
    public  DeliveryMan updateDeliveryMan(@RequestBody DeliveryMan deliveryMan) {
        return deliveryManService.update(deliveryMan);
    }

}
