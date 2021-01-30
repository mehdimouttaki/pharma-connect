package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @GetMapping("/pharmacies/add")
    public String addPharmacy() {
        return "/pharmacies/add_pharmacies";
    }

    @GetMapping("/pharmacies")
    public String allPharmacy(Model model) {
        List<Pharmacy> list = pharmacyService.getAll();
        model.addAttribute("pharmacies", list);
        return "/pharmacies/all_pharmacies";
    }

    @GetMapping("/pharmacies/edit")
    public String editPharmacy() {
        return "/pharmacies/edit_pharmacies";
    }


}
