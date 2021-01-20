package ma.pharmaconnect.app.pharmaconnect.model;

import java.util.Date;

public class HistoricalAddress {
    private Integer id;
    private String address;
    private Date lastModifiedDate;
    private Client client ;
    // Constructor with Parameters

    public HistoricalAddress(Integer id, String address, Date lastModifiedDate, Client client) {
        this.id = id;
        this.address = address;
        this.lastModifiedDate = lastModifiedDate;
        this.client = client;
    }

    // Constructor without Parameters
    public HistoricalAddress(){

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

