package edu.joyful.cqrs.command.api.controller;

import edu.joyful.cqrs.command.api.model.ProductRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CommandGateway commandGateway;

    @PostMapping
    public String addProduct(@RequestBody ProductRestModel productRestModel) {
        return "Product added";
    }
}
