package edu.joyful.orderservice.command.api.controller;

import edu.joyful.commonservice.api.dto.OrderRestModel;
import edu.joyful.commonservice.api.command.CreateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    private final CommandGateway gateway;

    @PostMapping
    public String createOrder(@RequestBody OrderRestModel order) {
        CreateOrderCommand command = CreateOrderCommand.builder()
                .orderId(randomUUID().toString())
                .addressId(order.getAddressId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .userId(order.getUserId())
                .orderStatus("CREATED")
                .build();

        gateway.sendAndWait(command);

        return "Order created";
    }
}
