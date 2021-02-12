package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.City;
import ma.pharmaconnect.app.pharmaconnect.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAll() {
        return (List<City>) cityRepository.findAll();
    }

    public City save(City city) {
        return cityRepository.save(city);
    }
}
