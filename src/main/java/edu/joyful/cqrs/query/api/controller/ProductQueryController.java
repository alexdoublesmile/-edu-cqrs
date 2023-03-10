package edu.joyful.cqrs.query.api.controller;

import edu.joyful.cqrs.command.api.model.dto.ProductDto;
import edu.joyful.cqrs.query.api.query.GetProductsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductQueryController {

    private final QueryGateway queryGateway;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        final GetProductsQuery getProductsQuery = new GetProductsQuery();

        final List<ProductDto> productDtoList = queryGateway
                .query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductDto.class))
                .join();

        return productDtoList;
    }
}
