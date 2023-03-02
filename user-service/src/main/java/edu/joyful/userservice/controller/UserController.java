package edu.joyful.userservice.controller;

import edu.joyful.commonservice.api.user.UserDto;
import edu.joyful.commonservice.api.user.query.GetUserPaymentDetailsQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final QueryGateway gateway;

    @GetMapping("/{userId}")
    public UserDto getUserPaymentDetails(@PathVariable String userId) {
        final GetUserPaymentDetailsQuery userQuery = GetUserPaymentDetailsQuery.builder()
                .userId(userId)
                .build();

        return gateway.query(userQuery, ResponseTypes.instanceOf(UserDto.class))
                .join();
    }
}
