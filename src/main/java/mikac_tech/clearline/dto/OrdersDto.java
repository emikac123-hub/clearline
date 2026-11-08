package mikac_tech.clearline.dto;
import java.time.Instant;

import mikac_tech.clearline.constants.OrderStatus;



public record OrdersDto(Instant bidPlacedAt, String bidPlacedBy, OrderStatus status) {

} 