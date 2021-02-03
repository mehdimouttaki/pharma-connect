package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermanentRestController {

    @Autowired
    private PermanentService permanentService;



    @GetMapping("/api/permanents")
    public List<Permanent> getAll() {
        return permanentService.getAll();
    }

    @GetMapping("/api/permanents/current")
    public List<Permanent> getCurrentPermanent() {
        return permanentService.getCurrentPermanent();
    }
}
