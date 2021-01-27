package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.repository.HistoricalAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalAddressService {
    @Autowired
    private HistoricalAddressRepository historicalAddressRepository;

    public List<HistoricalAddress> getAll() {

        return (List<HistoricalAddress>) historicalAddressRepository.findAll();
    }

    public HistoricalAddress getOne(Integer id) {

        return historicalAddressRepository.findById(id).get();
    }
}
