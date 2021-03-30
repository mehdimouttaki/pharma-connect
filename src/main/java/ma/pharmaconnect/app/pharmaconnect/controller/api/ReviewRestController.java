package ma.pharmaconnect.app.pharmaconnect.controller.api;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.dto.review.ReviewCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.dto.review.ReviewShowDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Client;
import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.model.User;
import ma.pharmaconnect.app.pharmaconnect.model.UserRole;
import ma.pharmaconnect.app.pharmaconnect.service.ClientService;
import ma.pharmaconnect.app.pharmaconnect.service.ReviewService;
import ma.pharmaconnect.app.pharmaconnect.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;
    private final ClientService clientService;
    private final UserService userService;

    @PostMapping("/api/reviews")
    public ReviewShowDTO addDReview(@RequestBody ReviewCreationDTO reviewDTO, @RequestHeader("username") String username) {
        Client client = clientService.getByUsername(username);
        Review review = new ModelMapper().map(reviewDTO, Review.class);
        review.setClient(client);
        Review reviewSaved = reviewService.save(review);
        return new ModelMapper().map(reviewSaved, ReviewShowDTO.class);
    }

    @GetMapping("/api/reviews")
    public List<ReviewShowDTO> getAll(@RequestHeader("username") String username) {
        User user = userService.getByUsername(username);
        List<Review> reviews = Collections.emptyList();
        if (UserRole.CLIENT.equals(user.getRole())) {
            reviews = reviewService.getAllByClientId(user.getId());
        } else if (UserRole.DELIVERY.equals(user.getRole())) {
            reviews = reviewService.getAllByDeliveryManId(user.getId());
        }
        return reviews
                .stream()
                .map(review -> new ModelMapper().map(review, ReviewShowDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/reviews/{id}")
    public Review getOne(@PathVariable Integer id) {
        return reviewService.getOne(id);
    }


}
