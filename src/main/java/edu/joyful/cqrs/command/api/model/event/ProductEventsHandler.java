package edu.joyful.cqrs.command.api.model.event;

import edu.joyful.cqrs.command.api.model.entity.Product;
import edu.joyful.cqrs.command.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {
    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreateEvent event) {
        final Product product = new Product();
        BeanUtils.copyProperties(event, product);

        productRepository.save(product);
    }
}
