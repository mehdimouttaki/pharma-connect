package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewRestController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/api/reviews")
    public Review addDReview(@RequestBody Review review){
        return reviewService.save(review);
    }
    @GetMapping("/api/reviews")
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/api/reviews/{id}")
    public Review getOne(@PathVariable Integer id) {
        return reviewService.getOne(id);
    }



}
