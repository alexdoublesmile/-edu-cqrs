package edu.joyful.cqrs.command.api.model.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateEvent {
    private String productId;
    private String name;
    private BigInteger price;
    private Integer quantity;
}
