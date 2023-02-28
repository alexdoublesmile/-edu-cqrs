package edu.joyful.orderservice.command.api.controller;

import edu.joyful.orderservice.command.api.model.OrderRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {
    private final CommandGateway gateway;

    @PostMapping
    public String createOrder(@RequestBody OrderRestModel order) {
        CreateOrderCommand command;

        gateway.sendAndWait(command);

        return "Order created";
    }
}
