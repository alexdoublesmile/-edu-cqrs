package edu.joyful.shipmentservice.model;

import edu.joyful.commonservice.api.command.ShipOrderCommand;
import edu.joyful.commonservice.api.event.OrderShippedEvent;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Slf4j
@Aggregate
@NoArgsConstructor
public class ShipmentAggregate {

    @AggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand command) {
        // TODO: 01.03.2023 validate payment details

        final OrderShippedEvent event = OrderShippedEvent.builder()
                .shipmentId(command.getShipmentId())
                .orderId(command.getOrderId())
                .shipmentStatus("COMPLETED")
                .build();

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(OrderShippedEvent event) {
        shipmentId = event.getShipmentId();
        orderId = event.getOrderId();
        shipmentStatus = event.getShipmentStatus();
    }
}
