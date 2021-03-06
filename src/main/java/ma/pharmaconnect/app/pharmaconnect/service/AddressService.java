package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Address;
import ma.pharmaconnect.app.pharmaconnect.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAll() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address getOne(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ClientAddress", id));
    }

    public Address add(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

    public List<Address> getAllByClientId(Integer id) {
        return addressRepository.findAllByClientId(id);
    }
}
