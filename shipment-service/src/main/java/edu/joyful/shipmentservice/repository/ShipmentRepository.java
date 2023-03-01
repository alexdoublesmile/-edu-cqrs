package edu.joyful.shipmentservice.repository;

import edu.joyful.shipmentservice.model.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, String> {
}
