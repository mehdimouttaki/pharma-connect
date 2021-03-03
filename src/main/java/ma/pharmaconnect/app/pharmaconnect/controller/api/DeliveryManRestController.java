package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManShowDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.delivery.DeliveryManUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.service.DeliveryManService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryManRestController {

    private final DeliveryManService deliveryManService;

    @PutMapping("/api/delivery-men")
    public DeliveryManShowDTO updateDeliveryMan(@RequestBody DeliveryManUpdateDTO deliveryManDTO) {
        DeliveryMan deliveryMan = new ModelMapper().map(deliveryManDTO, DeliveryMan.class);

        deliveryManService.update(deliveryMan);

        return new ModelMapper().map(deliveryMan, DeliveryManShowDTO.class);
    }

}
