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
    public void handle(OrderCreatedEvent event) {
        log.info("OrderCreatedEvent in SAGA for orderId: {}", event.getOrderId());

    }
}
