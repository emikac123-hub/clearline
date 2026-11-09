package mikac_tech.clearline.controller;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mikac_tech.clearline.dto.OrdersDto;
import mikac_tech.clearline.dto.StatusDto;
import mikac_tech.clearline.service.OrdersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/tenants/{tenantId}/orders")
public class OrdersController {

    private OrdersService ordersService;

    OrdersController(final OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<?> postMethodName(@PathVariable UUID tenantId, @RequestBody OrdersDto entity) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ordersService.createOrder(tenantId, entity));
    }

    /** 
     * return status (RESERVED | REJECTED) and reserved qty.
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<StatusDto> getStatusAndReservedQty(
            @PathVariable final UUID tenantId,
            @PathVariable final UUID orderId) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(this.ordersService.getStatusAndQty(tenantId, orderId));
    }
    
    
}