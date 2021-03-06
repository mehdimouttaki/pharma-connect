package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.client.AddressCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Address;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.AddressService;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;
    private final ClientService clientService;

    @GetMapping("/api/address")
    public List<Address> getAll() {
        return addressService.getAll();
    }


    @GetMapping("/api/my-address")
    public List<Address> getAllForClient(@RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        return addressService.getAllByClientId(client.getId());
    }

    @PostMapping("/api/address")
    public ResponseEntity<String> add(@RequestBody AddressCreationDTO addressCreationDTO, @RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        Address address = new Address();
        address.setAddress(addressCreationDTO.toString());
        address.setClient(client);
        addressService.add(address);
        return ResponseEntity.ok(address.toString());
    }

    @GetMapping("/api/address/{id}")
    public Address getOne(@PathVariable Integer id) {
        return addressService.getOne(id);
    }

    @DeleteMapping("/api/address/{id}")
    public void remove(@PathVariable Integer id) {
        addressService.delete(id);
    }
}
