package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String code;
    private Boolean prescription;
    @ManyToOne
    private Pharmacy pharmacy;
    // Constructor with Parameters

    public Product(Integer id, String name, Double price, String code, Boolean prescription,
                   Pharmacy pharmacy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.code = code;
        this.prescription = prescription;
        this.pharmacy = pharmacy;
    }

    //Constructor without  Parameters
    public Product() {

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

    public String getCode() {
        return code;
    }

    public void setCode(String coded) {
        this.code = coded;
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
