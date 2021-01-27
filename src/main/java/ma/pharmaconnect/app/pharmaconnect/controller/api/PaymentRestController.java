package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Payment;
import ma.pharmaconnect.app.pharmaconnect.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentRestController {
    private PaymentService paymentService;

    @PostMapping("api/payments")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.add(payment);
    }

    @DeleteMapping("/api/payments/{id}")
    public void deletePayment(@PathVariable Integer id) {
        paymentService.delete(id);
    }

    /*@PutMapping("/api/payments")
    public  Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }*/
    @GetMapping("/api/payments")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    @GetMapping("/api/payments/{id}")
    public Payment getOne(@PathVariable Integer id) {
        return paymentService.getOne(id);
    }
}
