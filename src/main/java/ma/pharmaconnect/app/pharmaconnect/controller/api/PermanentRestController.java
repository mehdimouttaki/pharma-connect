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
    //To delete
    @PostMapping("/api/permanents")
    public Permanent addDPermanent(@RequestBody Permanent permanent){
        return permanentService.save(permanent);
    }

    //To delete
    @DeleteMapping("/api/permanents/{id}")
    public void deletePermanent(@PathVariable Integer id){
        permanentService.delete(id);
    }

    //To delete
    @PutMapping("/api/permanents")
    public  Permanent updatePermanent(@RequestBody Permanent permanent) {
        return permanentService.update(permanent);
    }

    @GetMapping("/api/permanents")
    public List<Permanent> getAll() {
        return permanentService.getAll();
    }

    @GetMapping("/api/permanents/current")
    public List<Permanent> getCurrentPermanent() {
        return permanentService.getCurrentPermanent();
    }
}
