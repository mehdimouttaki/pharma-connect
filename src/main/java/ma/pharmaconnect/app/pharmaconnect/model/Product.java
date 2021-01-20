package ma.pharmaconnect.app.pharmaconnect.model;

public class Product {
    private Integer id ;
    private String name;
    private Double price;
    private Integer coded;
    private Boolean  prescription;
    private Pharmacy pharmacy;
    // Constructor with Parameters

    public Product(Integer id, String name, Double price, Integer coded, Boolean prescription, Pharmacy pharmacy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.coded = coded;
        this.prescription = prescription;
        this.pharmacy = pharmacy;
    }

    //Constructor without  Parameters
    public Product(){

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCoded() {
        return coded;
    }

    public void setCoded(Integer coded) {
        this.coded = coded;
    }

    public Boolean getPrescription() {
        return prescription;
    }

    public void setPrescription(Boolean prescription) {
        this.prescription = prescription;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
