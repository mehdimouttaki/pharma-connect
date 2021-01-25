package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer nbrProduct;
    private Double price;
    @ManyToOne
    private Client client;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryMan deliveryMan;
    @OneToOne
    private Payment payment;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Pharmacy pharmacy;

}
