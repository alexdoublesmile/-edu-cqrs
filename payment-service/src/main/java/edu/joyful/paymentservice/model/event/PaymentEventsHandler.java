package edu.joyful.paymentservice.model.event;

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
        Payment payment = new Payment();
        payment.setOrderId(event.getOrderId());
        payment.setPaymentId(event.getPaymentId());
        payment.setPaymentStatus("CREATED");
        payment.setPaymentTimestamp(new Date());

        paymentRepository.save(payment);
    }
}
