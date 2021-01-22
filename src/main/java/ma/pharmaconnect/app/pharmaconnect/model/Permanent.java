package ma.pharmaconnect.app.pharmaconnect.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Permanent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String type;

    @ManyToMany(mappedBy = "permanents")
    private List<Pharmacy> pharmacies;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }
}
