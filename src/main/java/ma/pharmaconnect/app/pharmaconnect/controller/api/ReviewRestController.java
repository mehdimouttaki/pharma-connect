package ma.pharmaconnect.app.pharmaconnect.controller.api;

import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewRestController {

    @Autowired
    private ReviewService reviewService;
    @PostMapping("/api/reviews")
    public Review addDReview(@RequestBody Review review){
        return reviewService.save(review);
    }

    @DeleteMapping("/api/reviews/{id}")
    public void deleteReview(@PathVariable Integer id){
        reviewService.delete(id);
    }

    @PutMapping("/api/reviews")
    public  Review updateReview(@RequestBody Review review) {
        return reviewService.update(review);
    }
}
