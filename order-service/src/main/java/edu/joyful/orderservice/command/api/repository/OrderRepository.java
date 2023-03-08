package edu.joyful.orderservice.command.api.repository;

import edu.joyful.orderservice.command.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
