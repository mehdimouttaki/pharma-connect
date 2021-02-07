package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User{

    @Column(unique = true)
    private String phone;

}
