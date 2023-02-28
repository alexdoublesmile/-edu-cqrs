package edu.joyful.orderservice.command.api.service.saga;

import edu.joyful.orderservice.command.api.model.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Slf4j
@Saga
public class OrderProcessingSaga {

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("OrderCreatedEvent in SAGA for orderId: {}", event.getOrderId());

        // TODO: 28.02.2023 get payment info from user-service
        // TODO: 28.02.2023 validate payment command create

        // TODO: 28.02.2023 get shipping info from shipment-service
        // TODO: 28.02.2023 ship command create

        // TODO: 28.02.2023 complete order command

        // TODO: 28.02.2023 send invoice command
    }
}
