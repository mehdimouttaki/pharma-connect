package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class PermanentController {

    private final PermanentService permanentService;

    @GetMapping("/permanents/add")
    public String addPermanent() {
        return "/permanents/add_permanents";
    }
    @ModelAttribute
    @GetMapping("/permanents")
    public String allPermanents(Model model) {
        List<Permanent> list = permanentService.getAll();
        model.addAttribute("permanents", list);
        return "/permanents/all_permanents";
    }

    @GetMapping("/permanents/edit")
    public String editPermanent() {
        return "/permanents/edit_permanents";
    }
    @PostMapping("/permanents/add")
    public String savePermanent(Permanent permanent) {
        permanentService.save(permanent);
        return "redirect:/permanents";
    }
    @GetMapping("/permanents/delete/{id}")
    public String deletePermanent(@PathVariable Integer id){
        permanentService.delete(id);
        return "redirect:/permanents";
    }


}
