package ma.pharmaconnect.app.pharmaconnect.controller.web;

import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PermanentController {
    @Autowired
    PermanentService permanentService;

    @GetMapping("/permanents/add")
    public String addPermanent() {
        return "/permanents/add_permanents";
    }

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


}
