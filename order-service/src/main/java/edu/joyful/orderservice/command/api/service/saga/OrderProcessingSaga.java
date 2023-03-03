package edu.joyful.orderservice.command.api.service.saga;

import edu.joyful.commonservice.api.order.command.CompleteOrderCommand;
import edu.joyful.commonservice.api.payment.command.CancelPaymentCommand;
import edu.joyful.commonservice.api.payment.command.ValidatePaymentCommand;
import edu.joyful.commonservice.api.payment.event.PaymentCancelledEvent;
import edu.joyful.commonservice.api.payment.event.PaymentProcessedEvent;
import edu.joyful.commonservice.api.shipment.command.ShipOrderCommand;
import edu.joyful.commonservice.api.shipment.event.OrderShippedEvent;
import edu.joyful.commonservice.api.user.UserDto;
import edu.joyful.commonservice.api.user.query.GetUserPaymentDetailsQuery;
import edu.joyful.orderservice.command.api.model.command.CancelOrderCommand;
import edu.joyful.orderservice.command.api.model.event.OrderCancelledEvent;
import edu.joyful.orderservice.command.api.model.event.OrderCompletedEvent;
import edu.joyful.orderservice.command.api.model.event.OrderCreatedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.UUID.randomUUID;

@Slf4j
@Saga
@NoArgsConstructor
public class OrderProcessingSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCreatedEvent event) {
        log.info("OrderCreatedEvent in SAGA for orderId: {}", event.getOrderId());

        final GetUserPaymentDetailsQuery userQuery = GetUserPaymentDetailsQuery.builder()
                .userId(event.getUserId())
                .build();

        UserDto userDto = null;
        try {
            userDto = queryGateway.query(userQuery, ResponseTypes.instanceOf(UserDto.class))
                    .join();
        } catch (Exception e) {
            log.error(e.getMessage());

            cancelOrderCommand(event.getOrderId());
        }

        final ValidatePaymentCommand paymentCommand = ValidatePaymentCommand.builder()
                .orderId(event.getOrderId())
                .paymentId(randomUUID().toString())
                .cardDetails(userDto.getCardDetails())
                .build();

        commandGateway.sendAndWait(paymentCommand);
    }

    private void cancelOrderCommand(String orderId) {
        final CancelOrderCommand cancelCommand = CancelOrderCommand.builder()
                .orderId(orderId)
                .orderStatus("CANCELLED")
                .build();

        commandGateway.sendAndWait(cancelCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(PaymentProcessedEvent event) {
        log.info("PaymentProcessedEvent in SAGA for orderId: {}", event.getOrderId());

        try {

            if (true) throw new Exception("test error");

            final ShipOrderCommand shipmentCommand = ShipOrderCommand.builder()
                    .orderId(event.getOrderId())
                    .shipmentId(randomUUID().toString())
                    .build();

            commandGateway.sendAndWait(shipmentCommand);

        } catch (Exception e) {
            log.error(e.getMessage());

            cancelPaymentCommand(event);
        }

    }

    private void cancelPaymentCommand(PaymentProcessedEvent event) {
        CancelPaymentCommand cancelCommand = CancelPaymentCommand.builder()
                .paymentId(event.getPaymentId())
                .orderId(event.getOrderId())
                .build();

        commandGateway.sendAndWait(cancelCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent event) {
        log.info("OrderShippedEvent in SAGA for orderId: {}", event.getOrderId());

        final CompleteOrderCommand orderCommand = CompleteOrderCommand.builder()
                .orderId(event.getOrderId())
                .orderStatus("APPROVED")
                .build();

        commandGateway.sendAndWait(orderCommand);
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCompletedEvent event) {
        log.info("OrderCompletedEvent in SAGA for orderId: {}", event.getOrderId());
    }

    @EndSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderCancelledEvent event) {
        log.info("OrderCancelledEvent in SAGA for orderId: {}", event.getOrderId());
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(PaymentCancelledEvent event) {
        log.info("PaymentCancelledEvent in SAGA for orderId: {}", event.getOrderId());

        cancelOrderCommand(event.getOrderId());
    }
}
