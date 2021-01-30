package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PharmacyController {
    @GetMapping("/pharmacies/add")
    public String addPharmacy() {
        return "/pharmacies/add_pharmacies";
    }

    @GetMapping("/pharmacies")
    public String allPharmacy() {
        return "/pharmacies/all_pharmacies";
    }

    @GetMapping("/pharmacies/edit")
    public String editPharmacy() {
        return "/pharmacies/edit_pharmacies";
    }


}
