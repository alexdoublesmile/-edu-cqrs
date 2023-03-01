package edu.joyful.orderservice.command.api.model.event;

import edu.joyful.orderservice.command.api.model.entity.Order;
import edu.joyful.orderservice.command.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventsHandler {

    private final OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        Order order = new Order();

        BeanUtils.copyProperties(event, order);

        orderRepository.save(order);
    }

    @EventHandler
    public void on(OrderCompletedEvent event) {
        final Order order = orderRepository.findById(event.getOrderId()).orElseThrow();

        order.setOrderStatus(event.getOrderStatus());

        orderRepository.save(order);
    }
}
