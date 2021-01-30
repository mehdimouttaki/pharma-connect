package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PermanentController {
    @GetMapping("/permanents/add")
    public String addPermanent() {
        return "/permanents/add_permanents";
    }

    @GetMapping("/permanents")
    public String allPermanent() {
        return "/permanents/all_permanents";
    }

    @GetMapping("/permanents/edit")
    public String editPermanent() {
        return "/permanents/edit_permanents";
    }


}
