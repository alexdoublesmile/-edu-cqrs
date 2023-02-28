package edu.joyful.orderservice.command.api.model.command;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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
        this.orderId = command.getOrderId();
        this.productId = command.getProductId();
        this.userId = command.getUserId();
        this.addressId = command.getAddressId();
        this.quantity = command.getQuantity();
        this.orderStatus = command.getOrderStatus();
    }
}
