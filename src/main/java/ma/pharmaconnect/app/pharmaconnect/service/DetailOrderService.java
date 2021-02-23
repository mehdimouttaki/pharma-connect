package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.DetailOrder;
import ma.pharmaconnect.app.pharmaconnect.repository.DetailOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailOrderService {
    private final DetailOrderRepository detailOrderRepository;

    public void saveAll(List<DetailOrder> detailOrders) {
        detailOrderRepository.saveAll(detailOrders);
    }
}
