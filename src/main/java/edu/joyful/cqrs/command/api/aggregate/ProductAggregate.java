package edu.joyful.cqrs.command.api.aggregate;

import edu.joyful.cqrs.command.api.command.CreateProductCommand;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigInteger;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigInteger price;
    private Integer quantity;

    public ProductAggregate(CreateProductCommand createProductCommand) {
        // TODO: 23.02.2023 perform validations
    }

    public ProductAggregate() {
    }
}
