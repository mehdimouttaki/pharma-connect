package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private Date createdAt;
    @ManyToOne
    private Client client;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryMan deliveryMan;
    @ManyToOne
    private Order order;

}
