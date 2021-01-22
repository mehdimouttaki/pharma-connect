package ma.pharmaconnect.app.pharmaconnect.model;

import java.util.Date;

public class Permanent {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private String type;

    // Constructor with Parameters
    public Permanent(Integer id, Date startDate, Date endDate, String type) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }
    // Constructor without Parameters
    public Permanent(){
    }
    //getters and setters

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
}
