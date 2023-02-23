package edu.joyful.cqrs.command.api.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@Entity
public class Product {
    @Id
    private String productId;
    private String name;
    private BigInteger price;
    private Integer quantity;
}
