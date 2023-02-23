package edu.joyful.cqrs.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class ProductRestModel {
    private String name;
    private BigInteger price;
    private Integer quantity;
}
