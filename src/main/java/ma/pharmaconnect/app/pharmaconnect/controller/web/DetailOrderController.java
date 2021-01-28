package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailOrderController {
    @GetMapping("/detail-order")
    public String allDetailOrder() {
        return "all_detail_order";
    }
}
