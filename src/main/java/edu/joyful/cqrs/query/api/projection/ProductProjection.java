package edu.joyful.cqrs.query.api.projection;

import edu.joyful.cqrs.command.api.model.dto.ProductRestModel;
import edu.joyful.cqrs.command.api.repository.ProductRepository;
import edu.joyful.cqrs.query.api.query.GetProductsQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductProjection {
    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {

    }
}
