package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String review;
    private Integer rate;
    @ManyToOne
    private Client client;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryMan deliveryMan;
    @ManyToOne
    private Order order;

}
