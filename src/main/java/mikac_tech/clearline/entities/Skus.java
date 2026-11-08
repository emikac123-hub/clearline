package mikac_tech.clearline.entities;

import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Skus extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID skuId;

    private Double price;

    private String displayName;

    @ManyToOne
    @JoinColumn(name = "tenant_id") 
    private Tenants tenant_id;

}
