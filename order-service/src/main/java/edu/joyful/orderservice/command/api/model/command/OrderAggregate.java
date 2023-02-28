package edu.joyful.orderservice.command.api.model.command;

import edu.joyful.orderservice.command.api.model.event.OrderCreatedEvent;
import org.axonframework.modelling.command.AggregateIdentifier;
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

        BeanUtils.copyProperties();

        this.orderId = command.getOrderId();
        this.productId = command.getProductId();
        this.userId = command.getUserId();
        this.addressId = command.getAddressId();
        this.quantity = command.getQuantity();
        this.orderStatus = command.getOrderStatus();
    }
}
