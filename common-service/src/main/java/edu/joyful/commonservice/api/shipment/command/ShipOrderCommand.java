package edu.joyful.commonservice.api.shipment.command;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipOrderCommand {

    private String shipmentId;
    private String orderId;
}
