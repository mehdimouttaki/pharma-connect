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
    @JoinColumn(nullable = false)
    private Date startDate;
    @JoinColumn(nullable = false)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private PermanentType type;

    @ManyToMany(mappedBy = "permanents")
    @JoinColumn(nullable = false)
    private List<Pharmacy> pharmacies;

}
