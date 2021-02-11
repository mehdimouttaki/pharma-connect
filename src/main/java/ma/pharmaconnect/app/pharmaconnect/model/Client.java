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
@Table(name = "client")
@PrimaryKeyJoinColumn(name = "id")
public class Client extends User implements Serializable {

    @Column(unique = true, nullable = false)
    private String phone;

}
