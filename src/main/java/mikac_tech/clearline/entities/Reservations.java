package mikac_tech.clearline.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Reservations extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID reservationId;


    @ManyToOne
    @JoinColumn(name = "order_id") 
    private Orders order_id;

    @ManyToOne
    @JoinColumn(name = "sku_id") 
    private Skus sku_id;

    @ManyToOne
    @JoinColumn(name = "tenant_id") 
    private Tenants tenant_id;

    private Integer qty;

    private Integer ordersPlaced;

}
