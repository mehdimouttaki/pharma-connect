package ma.pharmaconnect.app.pharmaconnect.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Ville {
    private Integer id;
    private String ville;
    private Integer region;
}
