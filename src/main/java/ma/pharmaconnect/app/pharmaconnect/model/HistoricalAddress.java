package ma.pharmaconnect.app.pharmaconnect.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoricalAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    private Date lastModifiedDate;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    // Constructor with Parameters

    public HistoricalAddress(Integer id, String address, Date lastModifiedDate, Client client) {
        this.id = id;
        this.address = address;
        this.lastModifiedDate = lastModifiedDate;
        this.client = client;
    }

    // Constructor without Parameters
    public HistoricalAddress() {

    }
    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

