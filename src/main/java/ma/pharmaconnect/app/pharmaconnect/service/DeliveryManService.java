package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.DeliveryMan;
import ma.pharmaconnect.app.pharmaconnect.model.UserRole;
import ma.pharmaconnect.app.pharmaconnect.repository.DeliveryManRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryManService {

    private final DeliveryManRepository deliveryManRepository;

    private final PasswordEncoder passwordEncoder;

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

    @Transactional
    public void update(DeliveryMan deliveryMan) {
        if (deliveryManRepository.existsById(deliveryMan.getId())) {
            deliveryManRepository.update(
                    deliveryMan.getId(),
                    deliveryMan.getPhone(),
                    deliveryMan.getFirstName(),
                    deliveryMan.getLastName(),
                    deliveryMan.getUsername());
        } else {
            throw new EntityNotFoundException("DeliveryMan", deliveryMan.getId());
        }


    }

    public List<DeliveryMan> getAll() {
        return (List<DeliveryMan>) deliveryManRepository.findAll();
    }

    public DeliveryMan getById(Integer id) {
        return deliveryManRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DeliveryMan", id));
    }

    public DeliveryMan getByUsername(String username) {
        return deliveryManRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Entity DeliveryMan with username '" + username + "' not found"));
    }
}
