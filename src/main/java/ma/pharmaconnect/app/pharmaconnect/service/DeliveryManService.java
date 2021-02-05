package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.UserRole;
import ma.pharmaconnect.app.pharmaconnect.repository.DeliveryManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManService {
    @Autowired
    private DeliveryManRepository deliveryManRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DeliveryMan save(DeliveryMan deliveryMan) {
        deliveryMan.setRole(UserRole.DELIVERY);

        deliveryMan.setPassword(
                passwordEncoder.encode(
                        deliveryMan.getPassword()
                )
        );
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
