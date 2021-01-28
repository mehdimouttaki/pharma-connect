package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    @GetMapping("/clients")
    public String allClients() {
        return "all_clients";
    }
}
