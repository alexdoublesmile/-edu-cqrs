package edu.joyful.commonservice.api.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCancelledEvent {

    private String paymentId;
    private String orderId;
    private String paymentStatus;
}
