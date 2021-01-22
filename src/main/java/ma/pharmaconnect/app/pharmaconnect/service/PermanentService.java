package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.repository.PermanentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermanentService {

    @Autowired
    private PermanentRepository permanentRepository;

    public List<Permanent> getAll() {
        return (List<Permanent>) permanentRepository.findAll();
    }

    public List<Permanent> getCurrentPermanent() {
        return permanentRepository.getCurrentPermanent();
    }
}
