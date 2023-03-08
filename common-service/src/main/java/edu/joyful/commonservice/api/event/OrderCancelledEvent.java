package edu.joyful.commonservice.api.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCancelledEvent {

    private String orderId;
    private String orderStatus;
}
