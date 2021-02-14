package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name = "delivery_man")
@PrimaryKeyJoinColumn(name = "id")
public class DeliveryMan extends User implements Serializable {

    @Column(unique = true, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "deliveryMan")
    private List<Order> orders = new ArrayList<>();
    @OneToMany(mappedBy = "deliveryMan")
    private List<Review> reviews = new ArrayList<>();

}
