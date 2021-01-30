package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoricalAddressController {
    @GetMapping("/historical-address")
    public String allHistoricalAddress() {
        return "/historical_adress/all_historical_address";
    }
}
