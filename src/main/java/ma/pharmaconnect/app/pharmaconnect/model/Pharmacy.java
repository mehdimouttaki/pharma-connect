package ma.pharmaconnect.app.pharmaconnect.model;

public class Pharmacy {
    private Integer id;
    private String name;
    private String address;
    private String pharmacist;
    private String product;
    // Constructor with Parameters

    public Pharmacy(Integer id, String name, String address, String pharmacist, String product) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pharmacist = pharmacist;
        this.product = product;
    }

    // Constructor without Parameters
    public Pharmacy(){

    }
    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(String pharmacist) {
        this.pharmacist = pharmacist;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}


