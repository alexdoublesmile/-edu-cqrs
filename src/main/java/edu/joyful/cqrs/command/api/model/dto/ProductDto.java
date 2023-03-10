package edu.joyful.cqrs.command.api.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class ProductDto {
    private String name;
    private BigInteger price;
    private Integer quantity;
}
