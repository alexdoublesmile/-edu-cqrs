package edu.joyful.orderservice.command.api.service.saga;

import edu.joyful.commonservice.api.user.dto.UserDto;
import edu.joyful.commonservice.api.user.query.GetUserPaymentDetailsQuery;
import edu.joyful.orderservice.command.api.model.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;

@Slf4j
@Saga
@RequiredArgsConstructor
public class OrderProcessingSaga {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    public void handleOrderCreated(OrderCreatedEvent event) {
        log.info("OrderCreatedEvent in SAGA for orderId: {}", event.getOrderId());

        final GetUserPaymentDetailsQuery userQuery = new GetUserPaymentDetailsQuery(event.getUserId());

        UserDto userDto = null;
        try {
            userDto = queryGateway.query(userQuery, ResponseTypes.instanceOf(UserDto.class))
                    .join();
        } catch (Exception e) {
            log.error(e.getMessage());
            // TODO: 01.03.2023 start compensation transaction
        }

        // TODO: 28.02.2023 validate payment command create

        // TODO: 28.02.2023 get shipping info from shipment-service
        // TODO: 28.02.2023 ship command create

        // TODO: 28.02.2023 complete order command

        // TODO: 28.02.2023 send invoice command
    }
}
