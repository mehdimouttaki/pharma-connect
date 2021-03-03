package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.repository.PermanentRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PermanentService {


    private final PermanentRepository permanentRepository;
    private final PharmacyRepository pharmacyRepository;

    public List<Permanent> getAll() {

        return (List<Permanent>) permanentRepository.findAll();
    }

    public Permanent save(Permanent permanent) {
        return permanentRepository.save(permanent);
    }

    public void delete(Integer id) {

        permanentRepository.deleteById(id);
    }


    public List<Permanent> getCurrentPermanent() {
        return permanentRepository.getCurrentPermanent();
    }

    public Permanent getOne(Integer id) {

        return permanentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permanents", id));
    }

    public void link(Integer permanentId, Integer pharmacyId) {
        Optional<Permanent> permanent = permanentRepository.findById(permanentId);
        Optional<Pharmacy> optionalPharmacy = pharmacyRepository.findById(pharmacyId);
        if (optionalPharmacy.isPresent()
                && permanent.isPresent()) {

            Pharmacy pharmacy = optionalPharmacy.get();
            pharmacy.getPermanents().add(permanent.get());

            pharmacyRepository.save(pharmacy);
        }
    }
}
