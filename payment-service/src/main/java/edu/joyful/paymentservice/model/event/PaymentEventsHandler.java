package edu.joyful.paymentservice.model.event;

import edu.joyful.commonservice.api.payment.event.PaymentCancelledEvent;
import edu.joyful.commonservice.api.payment.event.PaymentProcessedEvent;
import edu.joyful.paymentservice.model.entity.Payment;
import edu.joyful.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventsHandler {

    private final PaymentRepository paymentRepository;

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        Payment payment = Payment.builder()
                .orderId(event.getOrderId())
                .paymentId(event.getPaymentId())
                .paymentStatus("COMPLETED")
                .paymentTimestamp(new Date())
                .build();

        paymentRepository.save(payment);
    }

    @EventHandler
    public void on(PaymentCancelledEvent event) {
        final Payment payment = paymentRepository.findById(event.getPaymentId()).orElseThrow();

        payment.setPaymentStatus(event.getPaymentStatus());

        paymentRepository.save(payment);
    }
}
