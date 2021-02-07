package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.HistoricalAddress;
import ma.pharmaconnect.app.pharmaconnect.repository.HistoricalAddressRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricalAddressService {

    private final HistoricalAddressRepository historicalAddressRepository;

    public List<HistoricalAddress> getAll() {

        return (List<HistoricalAddress>) historicalAddressRepository.findAll();
    }

    public HistoricalAddress getOne(Integer id) {

        return historicalAddressRepository.findById(id).get();
    }
}
