package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Payment;
import ma.pharmaconnect.app.pharmaconnect.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

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
        return paymentRepository.findById(id).get();
    }
}
