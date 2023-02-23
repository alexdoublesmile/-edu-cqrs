package edu.joyful.cqrs.command.api.repository;

import edu.joyful.cqrs.command.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
