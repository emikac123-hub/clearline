package mikac_tech.clearline.entities;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Tenants extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID tenantId;

    private String tenantName;

    private Date lastKnownAccess;

}
