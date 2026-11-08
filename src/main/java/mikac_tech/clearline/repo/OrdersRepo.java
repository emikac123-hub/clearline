package mikac_tech.clearline.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import mikac_tech.clearline.entities.Orders;


@Repository 
public interface OrdersRepo extends JpaRepository<Orders, UUID> {
    
    @Query(value = "SELECT * FROM Orders WHERE tenant_id = :tenantId AND order_id = :orderId", nativeQuery = true)
    Orders getByTenantIdAndOrderIdf(@Param(value = "tenantId") final UUID tenantId, @Param(value = "orderId") final UUID orderId);
}
