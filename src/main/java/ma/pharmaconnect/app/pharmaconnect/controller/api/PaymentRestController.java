package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.model.Payment;
import ma.pharmaconnect.app.pharmaconnect.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentRestController {

    private final PaymentService paymentService;

    @PostMapping("api/payments")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.add(payment);
    }

    @DeleteMapping("/api/payments/{id}")
    public void deletePayment(@PathVariable Integer id) {
        paymentService.delete(id);
    }
    //To delete
    @GetMapping("/api/payments")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    //To delete
    @GetMapping("/api/payments/{id}")
    public Payment getOne(@PathVariable Integer id) {
        return paymentService.getOne(id);
    }
}
