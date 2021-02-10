package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.City;
import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.service.CityService;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;
    private final CityService cityService;

    @GetMapping("/pharmacies/add")
    public String addPharmacy(Model model) {
        List<City> list = cityService.getAll();
        model.addAttribute("cities", list);
        return "/pharmacies/add_pharmacies";
    }

    @PostMapping("/pharmacies/add")
    public String savePharmacy(Pharmacy pharmacy) {

        pharmacyService.save(pharmacy);
        return "redirect:/pharmacies";
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


    @GetMapping("/pharmacies/delete/{id}")
    public String deletePharmacy(@PathVariable Integer id){
        pharmacyService.delete(id);
        return "redirect:/pharmacies";
    }
}
