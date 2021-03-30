package ma.pharmaconnect.app.pharmaconnect.service;

import lombok.RequiredArgsConstructor;
import ma.pharmaconnect.app.pharmaconnect.exception.EntityNotFoundException;
import ma.pharmaconnect.app.pharmaconnect.model.Review;
import ma.pharmaconnect.app.pharmaconnect.repository.DeliveryManRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.OrderRepository;
import ma.pharmaconnect.app.pharmaconnect.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final DeliveryManRepository deliveryManRepository;
    private final OrderRepository orderRepository;

    public Review save(Review review) {
        Integer deliveryManId = review.getDeliveryMan().getId();
        Integer orderId = review.getOrder().getId();
        review.setDeliveryMan(
                deliveryManRepository
                        .findById(deliveryManId)
                        .orElseThrow(() -> new EntityNotFoundException("DeliveryMan", deliveryManId))

        );
        review.setOrder(
                orderRepository
                        .findById(orderId)
                        .orElseThrow(() -> new EntityNotFoundException("Order", orderId))
        );
        return reviewRepository.save(review);
    }

    public List<Review> getAll() {

        return (List<Review>) reviewRepository.findAll();
    }

    public Review getOne(Integer id) {

        return reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review", id));

    }
}
