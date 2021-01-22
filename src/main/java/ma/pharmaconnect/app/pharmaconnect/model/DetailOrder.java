package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;

@Entity
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productCode;
    @ManyToOne
    private Order order;
    //Constructor  with Parameters


    public DetailOrder(Integer id, String productCode, Order order) {
        this.id = id;
        this.productCode = productCode;
        this.order = order;
    }

    // Constructor without Parameters
    public DetailOrder() {

    }
    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
