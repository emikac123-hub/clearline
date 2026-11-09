package mikac_tech.clearline.entities;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mikac_tech.clearline.constants.*;;
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Builder 
public class Orders extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID reservationId;


    private Instant bidPlacedAt;

    private String bidPlacedBy;

    private String rejectionReason;

    private OrderStatus status;
    @ManyToOne 
    @JoinColumn(name = "tenant_id") 
    private Tenants tenant_id;

}
