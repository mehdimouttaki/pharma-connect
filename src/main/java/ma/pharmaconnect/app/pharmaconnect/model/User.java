package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(nullable = false)
    protected String lastName;
    @Column(nullable = false)
    protected String firstName;
    @Column(unique = true, nullable = false)
    protected String username;
    @Column(nullable = false)
    protected String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected UserRole role;
    @Column(name = "created_at", nullable = false)
    protected Date createdAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    protected UserStatus status;

    @PrePersist
    private void init() {
        if (createdAt == null) createdAt = new Date();
        if (status == null) status = UserStatus.ACTIVE;
    }
}
