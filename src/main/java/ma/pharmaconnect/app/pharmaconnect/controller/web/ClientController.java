package ma.pharmaconnect.app.pharmaconnect.controller.web;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public String allClient(Model model) {
        List<Client> list = clientService.getAll();
        model.addAttribute("clients", list);
        return "/clients/all_clients";
    }
    @GetMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
    @GetMapping("/clients/view/{id}")
    public String oneClient() {
        return "/clients/view_clients";
    }


}
