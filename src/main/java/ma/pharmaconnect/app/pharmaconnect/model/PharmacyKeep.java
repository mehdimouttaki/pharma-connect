package ma.pharmaconnect.app.pharmaconnect.model;

public class PharmacyKeep {
    private  Integer id;
    private Integer pharmacyId;
    private Integer keepId;

    // Constructor  with Parameters

    public PharmacyKeep(Integer id, Integer pharmacyId, Integer keepId) {
        this.id = id;
        this.pharmacyId = pharmacyId;
        this.keepId = keepId;
    }
    // Constructor  without Parameters
    public PharmacyKeep(){

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

    public Integer getKeepId() {
        return keepId;
    }

    public void setKeepId(Integer keepId) {
        this.keepId = keepId;
    }
}
