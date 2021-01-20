package ma.pharmaconnect.app.pharmaconnect.model;

public class Payment {
    private Integer id;
    private String statu;
    private String method;
    private Client client;
    private Order order;


    // Constructor  with Parameters

    public Payment(Integer id, String statu, String method, Client client, Order order) {
        this.id = id;
        this.statu = statu;
        this.method = method;
        this.client = client;
        this.order = order;
    }

    // Constructor without Parameters
    public Payment(){

    }
    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
