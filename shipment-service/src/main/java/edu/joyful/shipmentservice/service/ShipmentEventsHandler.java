package edu.joyful.shipmentservice.service;

import edu.joyful.commonservice.api.event.OrderShippedEvent;
import edu.joyful.shipmentservice.model.Shipment;
import edu.joyful.shipmentservice.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShipmentEventsHandler {

    private final ShipmentRepository shipmentRepository;

    @EventHandler
    public void on(OrderShippedEvent event) {
        Shipment shipment = new Shipment();

        BeanUtils.copyProperties(event, shipment);

        shipmentRepository.save(shipment);
    }
}
