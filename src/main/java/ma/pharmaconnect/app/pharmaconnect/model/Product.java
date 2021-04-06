package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ma.pharmaconnect.app.pharmaconnect.audit.AuditedEntity;
import ma.pharmaconnect.app.pharmaconnect.audit.AuditedField;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@Table(name = "product")
@AuditedEntity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @AuditedField
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private Boolean prescription;


}
