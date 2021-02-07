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
    private Date startDate;
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private PermanentType type;

    @ManyToMany(mappedBy = "permanents")
    private List<Pharmacy> pharmacies;

}
