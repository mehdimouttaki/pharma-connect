package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public List<HistoricalAddress> getAll() {
        return (List<HistoricalAddress>) addressRepository.findAll();
    }

    public HistoricalAddress getOne(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ClientAddress", id));
    }

    public HistoricalAddress add(String address) {
        return addressRepository.save(new HistoricalAddress().setAddress(address));
    }

    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }
}
