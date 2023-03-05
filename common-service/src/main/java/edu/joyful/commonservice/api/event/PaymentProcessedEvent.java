package edu.joyful.commonservice.api.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentProcessedEvent {

    private String paymentId;
    private String orderId;
}
