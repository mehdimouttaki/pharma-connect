package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter

@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User implements Serializable {

    @Column(unique = true, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Review> reviews = new ArrayList<>();

}
