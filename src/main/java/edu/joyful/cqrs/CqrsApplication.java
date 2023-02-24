package edu.joyful.cqrs;

import edu.joyful.cqrs.command.api.exception.ProductEventErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CqrsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsApplication.class, args);
    }

    @Autowired
    public void configure(EventProcessingConfigurer configurer) {
        configurer.registerListenerInvocationErrorHandler("product", configuration -> new ProductEventErrorHandler());
    }
}
