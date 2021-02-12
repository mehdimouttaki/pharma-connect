package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Payment;
import ma.pharmaconnect.app.pharmaconnect.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment add(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }


    public List<Payment> getAll() {
        return (List<Payment>) paymentRepository.findAll();
    }

    public Payment getOne(Integer id) {
        return paymentRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Payment",id);
        });
    }
}
