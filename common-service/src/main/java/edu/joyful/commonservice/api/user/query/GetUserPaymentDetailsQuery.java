package edu.joyful.commonservice.api.user.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserPaymentDetailsQuery {
    private String userId;
}
