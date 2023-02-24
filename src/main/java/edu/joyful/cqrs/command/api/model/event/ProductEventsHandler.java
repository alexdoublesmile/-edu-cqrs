package edu.joyful.cqrs.command.api.model.event;

import edu.joyful.cqrs.command.api.model.entity.Product;
import edu.joyful.cqrs.command.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//@ProcessingGroup("product")
public class ProductEventsHandler {
    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreateEvent event) throws Exception {
        final Product product = new Product();
        BeanUtils.copyProperties(event, product);

        productRepository.save(product);
//        throw new Exception("Exception occurs");
    }

//    @ExceptionHandler
//    public void handle(Exception exception) throws Exception {
//        throw exception;
//    }
}
