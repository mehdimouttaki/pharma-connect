package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientRestController {

    private final ClientService clientService;

    @PostMapping("/api/clients")
    public Client createClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @DeleteMapping("/api/clients/{id}")
    public void deleteClient(@PathVariable Integer id){
        clientService.delete(id);
    }

    @PutMapping("/api/clients")
    public  Client updateClient(@RequestBody Client client) {
        return clientService.update(client);
    }
}
