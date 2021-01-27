package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.service.HistoricalAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoricalAddressRestController {
    @Autowired
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
