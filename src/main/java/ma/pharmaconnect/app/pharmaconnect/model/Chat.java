package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(nullable = true)
    private String message;
    @JoinColumn(nullable = true)
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private DeliveryMan deliveryMan;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
