package ma.pharmaconnect.app.pharmaconnect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
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
    @JsonIgnore
    private List<Permanent> permanents;

}


