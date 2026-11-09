package mikac_tech.clearline.dto;

import mikac_tech.clearline.constants.OrderStatus;

public record StatusDto(OrderStatus status, Integer qty) {
    
}
