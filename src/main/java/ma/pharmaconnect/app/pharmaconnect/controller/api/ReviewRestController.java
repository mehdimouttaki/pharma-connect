package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.review.ReviewCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.review.ReviewShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import ma.pharmaconnect.app.pharmaconnect.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;
    private final ClientService clientService;

    @PostMapping("/api/reviews")
    public ReviewShowDTO addDReview(@RequestBody ReviewCreationDTO reviewDTO, @RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        Review review = new ModelMapper().map(reviewDTO, Review.class);
        review.setClient(client);
        Review reviewSaved = reviewService.save(review);
        return new ModelMapper().map(reviewSaved, (Type) ReviewShowDTO.class);
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
