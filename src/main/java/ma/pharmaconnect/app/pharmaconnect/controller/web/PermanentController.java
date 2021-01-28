package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PermanentController {
    @GetMapping("/permanent/add")
    public String addPermanent() {
        return "add_permanent";
    }

    @GetMapping("/permanent")
    public String allPermanent() {
        return "all_permanent";
    }

    @GetMapping("/permanent/edit")
    public String editPermanent() {
        return "edit_permanent";
    }

    @GetMapping("/permanent/delete")
    public String deletePermanent() {
        return "delete_permanent";
    }
}
