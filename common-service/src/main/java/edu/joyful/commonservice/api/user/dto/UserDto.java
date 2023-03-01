package edu.joyful.commonservice.api.user.dto;

import edu.joyful.commonservice.api.payment.dto.CardDetails;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String userId;
    private String firstName;
    private String lastName;
    private CardDetails cardDetails;
}
