package edu.joyful.cqrs.command.api.aggregate;

import edu.joyful.cqrs.command.api.command.CreateProductCommand;
import edu.joyful.cqrs.command.api.event.ProductCreateEvent;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigInteger;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigInteger price;
    private Integer quantity;

    public ProductAggregate(CreateProductCommand command) {
        // TODO: 23.02.2023 perform validations

        final ProductCreateEvent event = ProductCreateEvent.builder()
                .productId(command.getProductId())
                .name(command.getName())
                .price(command.getPrice())
                .quantity(command.getQuantity())
                .build();

        AggregateLifecycle.apply(event);
    }

    public ProductAggregate() {
    }
}
