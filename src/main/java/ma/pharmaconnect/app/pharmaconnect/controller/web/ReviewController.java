package ma.pharmaconnect.app.pharmaconnect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
    @GetMapping("/reviews")
    public String allReviews() {
        return "/reviews/all_reviews";
    }
}
