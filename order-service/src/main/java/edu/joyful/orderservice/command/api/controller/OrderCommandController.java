package edu.joyful.orderservice.command.api.controller;

import edu.joyful.orderservice.command.api.model.OrderRestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    @PostMapping
    public String createOrder(@RequestBody OrderRestModel order) {
        return "Order created";
    }
}
