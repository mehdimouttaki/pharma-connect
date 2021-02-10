package ma.pharmaconnect.app.pharmaconnect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(nullable = false)
    private String name;
    @JoinColumn(nullable = false)
    private String address;
    @JoinColumn(nullable = true)
    private String pharmacist;
    @JoinColumn(nullable = true)
    private Double lat;
    @JoinColumn(nullable = true)
    private Double lng;
    @ManyToOne
    @JoinColumn(name = "ville", nullable = false)
    private Ville ville;

    @ManyToMany
    @JoinTable(
            name = "lk_pharmacy_permanent",
            joinColumns = { @JoinColumn(name = "pharmacy_id") },
            inverseJoinColumns = { @JoinColumn(name = "permanent_id") }
    )
    @JsonIgnore
    @JoinColumn(nullable = true)
    private List<Permanent> permanents;

}
