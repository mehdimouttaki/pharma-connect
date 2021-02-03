package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@PrimaryKeyJoinColumn(name = "id")
public class DeliveryMan extends User {

    @Column(unique = true)
    private String phone;

}
