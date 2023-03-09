package edu.joyful.userservice.model;

import edu.joyful.commonservice.api.dto.CardDetails;
import edu.joyful.commonservice.api.dto.UserDto;
import edu.joyful.commonservice.api.query.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public UserDto handle(GetUserPaymentDetailsQuery query) {
        // TODO: 01.03.2023 do all this from DB

        final CardDetails card = CardDetails.builder()
                .cardNumber("123456")
                .name("Alex")
                .validUntilMonth(1)
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
