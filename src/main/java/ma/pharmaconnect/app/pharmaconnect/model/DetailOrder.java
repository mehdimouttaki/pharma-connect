package ma.pharmaconnect.app.pharmaconnect.model;

public class DetailOrder {
    private Integer id;
    private String productCode;
    private int orderId;
    //Constructor  with Parameters


    public DetailOrder(Integer id, String productCode, int orderId) {
        this.id = id;
        this.productCode = productCode;
        this.orderId = orderId;
    }

    // Constructor without Parameters
    public DetailOrder(){

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
