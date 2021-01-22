package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
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
    @ManyToOne
    private Payment payment;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Pharmacy pharmacy;

    // Constructor with Parameters

    public Order(Integer id, Integer nbrProduct, Double price, Client client, DeliveryMan deliveryMan,
                 Payment payment, Product product, Pharmacy pharmacy) {
        this.id = id;
        this.nbrProduct = nbrProduct;
        this.price = price;
        this.client = client;
        this.deliveryMan = deliveryMan;
        this.payment = payment;
        this.product = product;
        this.pharmacy = pharmacy;
    }

    // Constructor without Parameters
    public Order() {

    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNbrProduct() {
        return nbrProduct;
    }

    public void setNbrProduct(Integer nbrProduct) {
        this.nbrProduct = nbrProduct;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
