package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(nullable = true)
    private String review;
    @JoinColumn(nullable = true)
    private Integer rate;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "delivery_id",nullable = false)
    private DeliveryMan deliveryMan;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Order order;

}
