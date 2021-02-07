package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.service.HistoricalAddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HistoricalAddressRestController {

    private HistoricalAddressService historicalAddressService;

    @GetMapping("/api/historical-address")
    public List<HistoricalAddress> getAll() {
        return historicalAddressService.getAll();
    }

    @GetMapping("/api/historical-address/{id}")
    public HistoricalAddress getOne(@PathVariable Integer id) {
        return historicalAddressService.getOne(id);
    }
}
