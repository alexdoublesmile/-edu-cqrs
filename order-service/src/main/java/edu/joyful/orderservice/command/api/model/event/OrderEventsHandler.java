package edu.joyful.orderservice.command.api.model.event;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class OrderEventsHandler {

    @EventHandler
    public void on(OrderCreatedEvent event) {

    }
}
