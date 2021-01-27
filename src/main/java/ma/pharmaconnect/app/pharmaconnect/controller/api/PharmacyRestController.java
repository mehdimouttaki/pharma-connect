package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PharmacyRestController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/api/pharmacies")
    public List<Pharmacy> getAll() {
        return pharmacyService.getAll();
    }

    @GetMapping("/api/pharmacies/{id}")
    public Pharmacy getOne(@PathVariable Integer id) {

        return pharmacyService.getOne(id);
    }

}
