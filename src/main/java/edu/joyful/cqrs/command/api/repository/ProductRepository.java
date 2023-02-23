package edu.joyful.cqrs.command.api.repository;

import edu.joyful.cqrs.command.api.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
