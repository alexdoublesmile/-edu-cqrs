package edu.joyful.commonservice.api.user.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserPaymentDetailsQuery {
    private String userId;
}
