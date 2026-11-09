package mikac_tech.clearline.entities;

import java.util.UUID;

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
public class OrderLines extends AbstractAuditEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID orderLinesId;

    @ManyToOne 
    @JoinColumn(name = "order_id") 
    private Orders order_id;

    @ManyToOne 
    @JoinColumn(name = "sku_id") 
    private Skus sku_id;

    private Integer qty;

    private Integer ordersPlaced;

}
