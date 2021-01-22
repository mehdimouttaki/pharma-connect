package ma.pharmaconnect.app.pharmaconnect.model;

public class PharmacyPermanent {
    private  Integer id;
    private Integer pharmacyId;
    private Integer permanentId;

    // Constructor  with Parameters

    public PharmacyPermanent(Integer id, Integer pharmacyId, Integer permanentId) {
        this.id = id;
        this.pharmacyId = pharmacyId;
        this.permanentId = permanentId;
    }
    // Constructor  without Parameters
    public PharmacyPermanent(){

    }
    ////getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(Integer permanentId) {
        this.permanentId = permanentId;
    }
}
