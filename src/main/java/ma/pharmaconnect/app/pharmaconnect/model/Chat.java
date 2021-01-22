package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;
import java.util.Date;
@Entity
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

    //Constructor with Parameters


    public Chat(Integer id, String message, Date date, Client client, DeliveryMan deliveryMan,
                Order order) {
        this.id = id;
        this.message = message;
        this.createdAt = date;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.order = order;
    }

    // Constructor without Parameters
    public Chat() {

    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
