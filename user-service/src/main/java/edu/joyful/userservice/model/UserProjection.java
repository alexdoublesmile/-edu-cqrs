package edu.joyful.userservice.model;

import edu.joyful.commonservice.api.payment.CardDetails;
import edu.joyful.commonservice.api.user.UserDto;
import edu.joyful.commonservice.api.user.query.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public UserDto getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        // TODO: 01.03.2023 do all this from DB
        final CardDetails card = CardDetails.builder()
                .cardNumber("123456")
                .name("Alex")
                .validUntilMonth(01)
                .validUntilYear(2022)
                .cvv(111)
                .build();

        return UserDto.builder()
                .userId(query.getUserId())
                .firstName("Alex")
                .lastName("Smith")
                .cardDetails(card)
                .build();
    }
}
