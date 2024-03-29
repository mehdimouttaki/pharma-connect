package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "permanent")
public class Permanent implements Serializable {

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

    private List<Pharmacy> pharmacies = new ArrayList<>();

    public String show() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return type.name() + " [" + simpleDateFormat.format(startDate) + " - " + simpleDateFormat.format(endDate) + "]";
    }
    public String showDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return  " [" + simpleDateFormat.format(startDate) + " - " + simpleDateFormat.format(endDate) + "]";
    }

    public String showDateForUpdate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        return  simpleDateFormat.format(startDate) + " - " + simpleDateFormat.format(endDate);
    }

}
