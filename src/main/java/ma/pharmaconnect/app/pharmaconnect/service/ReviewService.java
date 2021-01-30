package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    public void delete(Integer id) {

        reviewRepository.deleteById(id);
    }

    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAll() {

        return (List<Review>) reviewRepository.findAll();
    }
}
