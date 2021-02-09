package ma.pharmaconnect.app.pharmaconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;
@Setter
@Getter
@ToString
public class PharmacyDTO {
    private Integer id;
    private String name;
    private String address;
    private String pharmacist;
    private Double lat;
    private Double lng;


    @JsonIgnore
    private List<PermanentDTO> permanentDTOS;

}
