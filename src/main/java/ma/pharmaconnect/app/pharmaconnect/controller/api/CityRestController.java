package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.CityDTO;
import ma.pharmaconnect.app.pharmaconnect.model.City;
import ma.pharmaconnect.app.pharmaconnect.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CityRestController {

    private final CityService cityService;

    @GetMapping("/api/cities")
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PostMapping("/api/cities")
    public City save(@RequestBody CityDTO cityDTO) {


        City city = new City();

        city.setLabel(cityDTO.getLabel());


        return cityService.save(city);
    }
}
