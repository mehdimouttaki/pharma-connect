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

    public Permanent save(Permanent permanent) {
        return permanentRepository.save(permanent);
    }

    public void delete(Integer id) {

        permanentRepository.deleteById(id);
    }
    public Permanent update(Permanent permanent){

        return permanentRepository.save(permanent);
    }

    public List<Permanent> getAll() {

        return (List<Permanent>) permanentRepository.findAll();
    }

    public List<Permanent> getCurrentPermanent()
    {
        return permanentRepository.getCurrentPermanent();
    }
}
