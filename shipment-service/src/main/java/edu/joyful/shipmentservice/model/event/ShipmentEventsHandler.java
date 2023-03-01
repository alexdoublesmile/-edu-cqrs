package edu.joyful.shipmentservice.model.event;

import edu.joyful.commonservice.api.shipment.event.OrderShippedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShipmentEventsHandler {

    private final ShipmentRepository shipmentRepository;

    public void on(OrderShippedEvent event) {
        shipmentRepository.save();
    }
}
