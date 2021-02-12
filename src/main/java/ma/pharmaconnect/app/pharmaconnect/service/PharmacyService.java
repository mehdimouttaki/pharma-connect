package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.repository.CityRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PharmacyService {

    private final PharmacyRepository pharmacyRepository;
    private final CityRepository cityRepository;

    public List<Pharmacy> getAll() {

        return (List<Pharmacy>) pharmacyRepository.findAll();
    }

    public Pharmacy getOne(Integer id) {

        return pharmacyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pharmacy", id));
    }

    public Pharmacy save(Pharmacy pharmacy) {
        //take the id coming from html select box
        Integer cityId = pharmacy.getCity().getId();
        pharmacy.setCity(cityRepository.findById(cityId).get());
        return pharmacyRepository.save(pharmacy);
    }

    public void delete(Integer id) {
        pharmacyRepository.deleteById(id);
    }
}
