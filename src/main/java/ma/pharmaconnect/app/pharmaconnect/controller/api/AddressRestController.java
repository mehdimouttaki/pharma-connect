package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.client.AddressCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Address;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.service.AddressService;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<String> getAllForClient(@RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        List<Address> addresses = addressService.getAllByClientId(client.getId());
        return addresses
                .stream()
                .map(Address::getAddress)
                .collect(Collectors.toList());

    }

    @PostMapping("/api/address")
    public Map<String, String> add(@RequestBody AddressCreationDTO addressCreationDTO, @RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        Address address = new Address();
        address.setAddress(addressCreationDTO.toString());
        address.setClient(client);
        addressService.add(address);
        return Collections.singletonMap("address", address.getAddress());
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
