package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PharmacyController {
    @GetMapping("/pharmacies/add")
    public String addPharmacy() {
        return "add_pharmacies";
    }

    @GetMapping("/pharmacies")
    public String allPharmacy() {
        return "all_pharmacies";
    }

    @GetMapping("/pharmacies/edit")
    public String editPharmacy() {
        return "edit_pharmacies";
    }

    @GetMapping("/pharmacies/delete")
    public String deletePharmacy() {
        return "delete_pharmacies";
    }
}
