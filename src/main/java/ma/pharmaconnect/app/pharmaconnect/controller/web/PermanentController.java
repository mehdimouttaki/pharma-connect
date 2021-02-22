package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.permanent.PermanentCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.permanent.PermanentUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.mapper.PermanentMapper;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.model.Pharmacy;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import ma.pharmaconnect.app.pharmaconnect.service.PharmacyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PermanentController {

    private final PermanentService permanentService;
    private final PharmacyService pharmacyService;

    @GetMapping("/permanents/add")
    public String addPermanent(Model model) {
        List<Pharmacy> list= pharmacyService.getAll();
        model.addAttribute("pharmacies",list);
        return "/permanents/add_permanents";
    }

    @GetMapping("/permanents")
    public String allPermanents(Model model) {
        List<Permanent> list = permanentService.getAll();
        model.addAttribute("permanents", list);
        return "/permanents/all_permanents";
    }

    @GetMapping("/permanents/edit/{id}")
    public String editPermanents(Model model, @PathVariable Integer id) {

        Permanent permanent = permanentService.getOne(id);
        model.addAttribute("permanents", permanent);
        return "/permanents/edit_permanents";
    }
    @PostMapping("/permanents/edit")
    public String updatePermanents(PermanentUpdateDTO permanentsDTO) {
        Permanent permanent = new ModelMapper().map(permanentsDTO, Permanent.class);
        permanentService.save(permanent);
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


}
