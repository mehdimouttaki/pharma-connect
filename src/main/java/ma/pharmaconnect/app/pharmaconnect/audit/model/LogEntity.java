package ma.pharmaconnect.app.pharmaconnect.audit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Accessors(chain = true)
public class LogEntity {

    private Long id;
    private String entity;
    private String entityId;
    private String field;
    private String oldValue;
    private String newValue;
    @Enumerated(EnumType.STRING)
    private AuditAction action;
}
