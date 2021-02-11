package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@Table(name = "delivery_man")
@PrimaryKeyJoinColumn(name = "id")
public class DeliveryMan extends User implements Serializable {

    @Column(unique = true, nullable = false)
    private String phone;

}
