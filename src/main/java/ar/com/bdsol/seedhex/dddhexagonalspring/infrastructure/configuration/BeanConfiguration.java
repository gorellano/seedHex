package ar.com.bdsol.seedhex.dddhexagonalspring.infrastructure.configuration;

import ar.com.bdsol.seedhex.SeedhexApplication;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.service.DomainOrderService;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.service.OrderService;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SeedhexApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
