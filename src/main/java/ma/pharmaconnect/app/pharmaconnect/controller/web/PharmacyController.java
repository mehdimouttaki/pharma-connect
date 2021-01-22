package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PharmacyController {
    @Autowired
    private PharmacyService pharmacyService;

    public List<Pharmacy> getAll() {
        return pharmacyService.getAll();
    }

    public List<Pharmacy> addPharmacy() {
        return pharmacyService.getAll();
    }
}
