package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.repository.DeliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManService {
    @Autowired
    private DeliveryManRepository deliveryManRepository;

    public DeliveryMan save(DeliveryMan deliveryMan) {
        return deliveryManRepository.save(deliveryMan);
    }

    public void delete(Integer id) {

        deliveryManRepository.deleteById(id);
    }

    public DeliveryMan update(DeliveryMan deliveryMan) {

        return deliveryManRepository.save(deliveryMan);
    }

    public List<DeliveryMan> getAll() {
        return (List<DeliveryMan>) deliveryManRepository.findAll();
    }
}
