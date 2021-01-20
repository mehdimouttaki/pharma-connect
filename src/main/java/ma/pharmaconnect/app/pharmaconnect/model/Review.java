package ma.pharmaconnect.app.pharmaconnect.model;

public class Review {
    private Integer id ;
    private String review ;
    private Integer rate;

    private Client client;
    private DeliveryMan deliveryMan;
    private Order order;

    // Constructor with Parameters

    public Review(Integer id, String review, Integer rate, Client client, DeliveryMan deliveryMan, Order order) {
        this.id = id;
        this.review = review;
        this.rate = rate;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.order = order;
    }

    // Constructor without  Parameters
    public Review(){

    }
    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
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
