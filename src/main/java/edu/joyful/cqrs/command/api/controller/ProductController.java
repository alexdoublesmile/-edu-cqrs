package edu.joyful.cqrs.command.api.controller;

import edu.joyful.cqrs.command.api.model.command.CreateProductCommand;
import edu.joyful.cqrs.command.api.model.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CommandGateway commandGateway;

    @PostMapping
    public String addProduct(@RequestBody ProductDto productDto) {
        final CreateProductCommand command = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .build();

        final String result = commandGateway.sendAndWait(command);

        return result;
    }
}
