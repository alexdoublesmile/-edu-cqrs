package edu.joyful.paymentservice.repository;

import edu.joyful.paymentservice.model.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}
