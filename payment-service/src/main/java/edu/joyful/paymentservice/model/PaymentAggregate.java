package edu.joyful.paymentservice.model;

import edu.joyful.commonservice.api.payment.command.ValidatePaymentCommand;
import edu.joyful.commonservice.api.payment.event.PaymentProcessedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
public class PaymentAggregate {

    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private String paymentStatus;

    public PaymentAggregate() {
    }

    @CommandHandler
    public PaymentAggregate(ValidatePaymentCommand command) {
        // TODO: 01.03.2023 validate payment details
        log.info("Executing ValidatePaymentCommand for orderId: {} and paymentId: {}",
                command.getOrderId(), command.getPaymentId());

        final PaymentProcessedEvent event = PaymentProcessedEvent.builder()
                .orderId(command.getOrderId())
                .paymentId(command.getPaymentId())
                .build();

        AggregateLifecycle.apply(event);
        log.info("PaymentProcessedEvent Applied");
    }

    @EventSourcingHandler
    public void on(PaymentProcessedEvent event) {
        paymentId = event.getPaymentId();
        orderId = event.getOrderId();
    }
}