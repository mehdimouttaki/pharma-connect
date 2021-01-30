package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.repository.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyService {
    @Autowired
    private PharmacyRepository pharmacyRepository;

    public List<Pharmacy> getAll() {

        return (List<Pharmacy>) pharmacyRepository.findAll();
    }

    public Pharmacy getOne(Integer id) {

        return pharmacyRepository.findById(id).get();
    }

    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }
}
