package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.PermanentPharmacyLinkDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.permanent.PermanentCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.permanent.PermanentUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.mapper.PermanentMapper;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PermanentController {

    private final PermanentService permanentService;
    private final PharmacyService pharmacyService;

    @GetMapping("/permanents/add")
    public String addPermanent(Model model) {
        model.addAttribute("pharmacies", pharmacyService.getAll());
        model.addAttribute("permanents", permanentService.getAll());
        return "/permanents/add_permanents";
    }

    @GetMapping("/permanents")
    public String allPermanents(Model model) {
        model.addAttribute("permanents", permanentService.getAll());
        return "/permanents/all_permanents";
    }

    @GetMapping("/permanents/edit/{id}")
    public String editPermanents(Model model, @PathVariable Integer id) {
        model.addAttribute("permanent", permanentService.getOne(id));
        return "/permanents/edit_permanents";
    }

    @PostMapping("/permanents/edit")
    public String updatePermanents(PermanentUpdateDTO permanentsDTO) {
        Permanent permanent = PermanentMapper.map(permanentsDTO);
        permanentService.update(permanentsDTO.getId(), permanent);
        return "redirect:/permanents";
    }

    @PostMapping("/permanents/add")
    public String savePermanent(PermanentCreationDTO permanentDTO) {

        Permanent permanent = PermanentMapper.map(permanentDTO);

        permanentService.save(permanent);
        return "redirect:/permanents";
    }

    @GetMapping("/permanents/delete/{id}")
    public String deletePermanent(@PathVariable Integer id) {
        permanentService.delete(id);
        return "redirect:/permanents";
    }

    @GetMapping("/permanents/view/{id}")
    public String onePermanent(@PathVariable Integer id, Model model) {
        Permanent permanent = permanentService.getOne(id);
        model.addAttribute("permanent", permanent);
        return "/permanents/view_permanent";
    }

    @PostMapping("/permanents/link-pharmacy")
    public String linkPharmacy(PermanentPharmacyLinkDTO pharmacyLinkDTO) {
        permanentService.link(pharmacyLinkDTO.getPermanentId(), pharmacyLinkDTO.getPharmacyId());
        return "redirect:/permanents";
    }


}
