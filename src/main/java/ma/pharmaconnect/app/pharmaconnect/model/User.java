package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @JoinColumn(nullable = false)
    protected String lastName;
    @JoinColumn(nullable = false)
    protected String firstName;
    @Column(unique = true,nullable = false)
    protected String username;
    @JoinColumn(nullable = false)
    protected String password;
    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    protected UserRole role;

}
