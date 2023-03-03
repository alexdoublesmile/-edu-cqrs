package edu.joyful.commonservice.api.payment.command;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class CancelPaymentCommand {

    @TargetAggregateIdentifier
    String paymentId;
    String orderId;
    String paymentStatus = "CANCELLED";
}
