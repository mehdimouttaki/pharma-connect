package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.service.PermanentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermanentRestController {


    private final PermanentService permanentService;



    @GetMapping("/api/permanents")
    public List<Permanent> getAll() {
        return permanentService.getAll();
    }

    @GetMapping("/api/permanents/current")
    public List<Permanent> getCurrentPermanent() {
        return permanentService.getCurrentPermanent();
    }
}
