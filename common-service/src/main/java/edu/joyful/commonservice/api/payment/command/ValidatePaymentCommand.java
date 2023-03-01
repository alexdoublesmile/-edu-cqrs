package edu.joyful.commonservice.api.payment.command;

import edu.joyful.commonservice.api.payment.CardDetails;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ValidatePaymentCommand {

    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;
}
