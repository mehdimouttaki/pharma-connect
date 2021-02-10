package ma.pharmaconnect.app.pharmaconnect.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name = "pharmacy")
public class Pharmacy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = true)
    private String pharmacist;
    @Column(nullable = true)
    private Double lat;
    @Column(nullable = true)
    private Double lng;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "city", nullable = false)
    private City city;

    @ManyToMany
    @JoinTable(
            name = "lk_pharmacy_permanent",
            joinColumns = {@JoinColumn(name = "pharmacy_id")},
            inverseJoinColumns = {@JoinColumn(name = "permanent_id")}
    )
    @JsonIgnore
    @JoinColumn(nullable = true)
    private List<Permanent> permanents;

}
