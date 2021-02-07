package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(nullable = false)
    private String name;
    @JoinColumn(nullable = false)
    private Double price;
    @JoinColumn(nullable = false)
    private String code;
    @JoinColumn(nullable = false)
    private Boolean prescription;


}
