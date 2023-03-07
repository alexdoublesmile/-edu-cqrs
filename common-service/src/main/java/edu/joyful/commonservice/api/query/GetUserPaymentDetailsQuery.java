package edu.joyful.commonservice.api.query;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserPaymentDetailsQuery {

    private String userId;
}
