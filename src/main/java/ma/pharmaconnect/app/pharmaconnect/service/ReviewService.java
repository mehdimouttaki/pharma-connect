package ma.pharmaconnect.app.pharmaconnect.service;

import ma.pharmaconnect.app.pharmaconnect.model.Chat;
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





    public List<Review> getAll() {

        return (List<Review>) reviewRepository.findAll();
    }

    public Review getOne(Integer id) {

        return reviewRepository.findById(id).get();
    }
}
