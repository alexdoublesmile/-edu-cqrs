package edu.joyful.orderservice.command.api.model.command;

import edu.joyful.orderservice.command.api.model.event.OrderCreatedEvent;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;

    public OrderAggregate() {
    }

    public OrderAggregate(CreateOrderCommand command) {
        final OrderCreatedEvent event = new OrderCreatedEvent();

        BeanUtils.copyProperties(command, event);

        AggregateLifecycle.apply(event);
    }
}
