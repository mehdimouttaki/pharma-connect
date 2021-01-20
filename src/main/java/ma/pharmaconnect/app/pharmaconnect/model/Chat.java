package ma.pharmaconnect.app.pharmaconnect.model;

import java.util.Date;

public class Chat {
    private Integer id ;
    private String message;
    private Date date;
    private Client client;
    private DeliveryMan deliveryMan;
    private Order order ;
    

    //Constructor with Parameters


    public Chat(Integer id, String message, Date date, Client client, DeliveryMan deliveryMan, Order order) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.order = order;
    }

    // Constructor without Parameters
    public Chat(){

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
