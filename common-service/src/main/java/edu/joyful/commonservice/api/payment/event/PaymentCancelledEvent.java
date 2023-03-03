package edu.joyful.commonservice.api.payment.event;

import lombok.Data;

@Data
public class PaymentCancelledEvent {
    private String paymentId;
    private String orderId;
    private final String paymentStatus;
}
