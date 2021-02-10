package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "permanent")
public class Permanent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermanentType type;

    @ManyToMany(mappedBy = "permanents")

    private List<Pharmacy> pharmacies;

}
