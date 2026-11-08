package mikac_tech.clearline.service;


import java.io.ObjectInputFilter.Status;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import mikac_tech.clearline.dto.OrdersDto;
import mikac_tech.clearline.dto.StatusDto;
import mikac_tech.clearline.constants.OrderStatus;
import mikac_tech.clearline.entities.OrderLines;
import mikac_tech.clearline.entities.Orders;
import mikac_tech.clearline.entities.Tenants;
import mikac_tech.clearline.repo.OrderLinesRepo;
import mikac_tech.clearline.repo.OrdersRepo;
import mikac_tech.clearline.repo.TenantsRepo;

@Service
public class OrdersService {
    
    private TenantsRepo tenantsRepo;
    private OrderLinesRepo orderLinesRepo;
    private OrdersRepo ordersRepo;

    OrdersService(final TenantsRepo tenantsRepo, final OrderLinesRepo orderLinesRepo, final OrdersRepo ordersRepo) {
        this.tenantsRepo = tenantsRepo;
        this.orderLinesRepo = orderLinesRepo;
        this.ordersRepo = ordersRepo;
    }

    /**
     * create order and attempt reservation in one request/transaction.
     * @param tenant_id
     * @return
     */
    public Orders createOrder(UUID tenant_id, OrdersDto ordersDto) throws ResourceNotFoundException{
        final Tenants tenant = Optional.of(this.tenantsRepo.getReferenceById(tenant_id))
        .orElseThrow(() -> new ResourceNotFoundException("The tenant does not exist in our system."));;
        
        final Orders order = Orders.builder()
        .bidPlacedAt(Instant.now())
        .bidPlacedBy(tenant.getTenantName())
        .tenant_id(tenant)
        .rejectionReason(null)
        .status(OrderStatus.RESERVED)
        .build();
        this.ordersRepo.save(order);
        return order;
    }

    public StatusDto getStatusAndQty(final UUID tenantId, final UUID orderId) {
        final OrderLines orderLine = Optional.of(this.orderLinesRepo.getByTenantIdAndOrderIdf(tenantId, orderId))
        .orElseThrow(() -> new ResourceNotFoundException("The order does not exist in our system."));
      
        final OrderStatus status = orderLine.getOrder_id().getStatus();
        return new StatusDto(status , orderLine.getQty());

    }

  
}
