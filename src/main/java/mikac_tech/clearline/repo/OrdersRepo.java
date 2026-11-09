package mikac_tech.clearline.repo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mikac_tech.clearline.entities.Orders;


@Repository 
public interface OrdersRepo extends JpaRepository<Orders, UUID> {
    

}
