package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.client.AddressCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressRestController {

    private final AddressService addressService;

    @GetMapping("/api/address")
    public List<HistoricalAddress> getAll() {
        return addressService.getAll();
    }

    @PostMapping("/api/address")
    public HistoricalAddress add(@RequestBody AddressCreationDTO addressCreationDTO) {
        return addressService.add(addressCreationDTO.getAddress());
    }

    @GetMapping("/api/address/{id}")
    public HistoricalAddress getOne(@PathVariable Integer id) {
        return addressService.getOne(id);
    }

    @DeleteMapping("/api/address/{id}")
    public void remove(@PathVariable Integer id) {
        addressService.delete(id);
    }
}
