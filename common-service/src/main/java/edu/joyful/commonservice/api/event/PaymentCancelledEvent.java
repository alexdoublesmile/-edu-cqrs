package edu.joyful.commonservice.api.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCancelledEvent {

    private String paymentId;
    private String orderId;
    private String paymentStatus;
}
