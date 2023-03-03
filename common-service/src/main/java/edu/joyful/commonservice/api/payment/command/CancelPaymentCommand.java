package edu.joyful.commonservice.api.payment.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CancelPaymentCommand {

    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;

    @Builder.Default
    private final String paymentStatus = "CANCELLED";
}
