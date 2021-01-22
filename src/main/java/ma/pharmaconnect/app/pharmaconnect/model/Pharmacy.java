package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String pharmacist;
    private Double lat;
    private Double lng;

    @ManyToMany
    @JoinTable(
            name = "lk_pharmacy_permanent",
            joinColumns = { @JoinColumn(name = "pharmacy_id") },
            inverseJoinColumns = { @JoinColumn(name = "keep_id") }
    )
    private List<Permanent> permanents;

    public Pharmacy(Integer id, String name, String address, String pharmacist, Double lat, Double lng) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pharmacist = pharmacist;
        this.lat = lat;
        this.lng = lng;
    }

    // Constructor without Parameters
    public Pharmacy() {

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public List<Permanent> getPermanents() {
        return permanents;
    }

    public void setPermanents(List<Permanent> permanents) {
        this.permanents = permanents;
    }
}


