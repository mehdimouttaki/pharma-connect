package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientShowDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.client.ClientUpdateDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ClientRestController {

    private final ClientService clientService;

    @PostMapping("/api/clients")
    public ClientShowDTO createClient(@RequestBody ClientCreationDTO clientDTO) {
        //transform from clientDto to client
        Client client = new ModelMapper().map(clientDTO, Client.class);

        //save client( entity) in data base and we got a saved entity (client)
        Client clientSaved = clientService.save(client);

        //transform from client to clientShowDto
        return new ModelMapper().map(clientSaved, ClientShowDTO.class);

    }

    @DeleteMapping("/api/clients/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }

    @PutMapping("/api/clients")
    public ClientShowDTO updateClient(@RequestBody ClientUpdateDTO clientDTO) {

        Client client = new ModelMapper().map(clientDTO, Client.class);

        //Update client
        Client clientUpdated = clientService.update(client);

        //transform from client to clientShowDto
        return new ModelMapper().map(clientUpdated, ClientShowDTO.class);
    }
}
