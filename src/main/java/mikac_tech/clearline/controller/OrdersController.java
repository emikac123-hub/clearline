package mikac_tech.clearline.controller;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import mikac_tech.clearline.dto.OrdersDto;
import mikac_tech.clearline.service.OrdersService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/tenants")
public class OrdersController {

    private OrdersService ordersService;

    OrdersController(final OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/{tenantId}/orders")
    public ResponseEntity<?> postMethodName(@PathVariable UUID tenentId, @RequestBody OrdersDto entity) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ordersService.createOrder(tenentId, entity));
    }

    /** 
     * return status (RESERVED | REJECTED) and reserved qty.
     */
    @GetMapping("/{tenantId}/orders/{orderid}")
    public String getStatusAndReservedQty(@PathVariable final String tenantid, @PathVariable final String orderId) {
        return new String();
    }
    
    
}