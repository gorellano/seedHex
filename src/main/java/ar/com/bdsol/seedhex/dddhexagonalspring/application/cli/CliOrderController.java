package ar.com.bdsol.seedhex.dddhexagonalspring.application.cli;

import java.math.BigDecimal;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.com.bdsol.seedhex.dddhexagonalspring.domain.Product;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.service.OrderService;

@Component
public class CliOrderController {

    private static final Logger LOG = LoggerFactory.getLogger(CliOrderController.class);

    private final OrderService orderService;

    @Autowired
    public CliOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createCompleteOrder() {
        LOG.info("<<Create complete order>>");
        UUID orderId = createOrder();
        LOG.info("Create complete order id: ");
        LOG.info(String.valueOf(orderId));
        orderService.completeOrder(orderId);
    }

    public void createIncompleteOrder() {
        LOG.info("<<Create incomplete order>>");
        UUID orderId = createOrderIncompl();
        LOG.info("Create incomplete order id: ");
        LOG.info(String.valueOf(orderId));
    }

    private UUID createOrder() {
        LOG.info("Placing a new order with two products");
        Product mobilePhone = new Product(UUID.randomUUID(), BigDecimal.valueOf(200), "mobile");
        Product razor = new Product(UUID.randomUUID(), BigDecimal.valueOf(50), "razor");
        LOG.info("Creating order with mobile phone");
        UUID orderId = orderService.createOrder(mobilePhone);
        LOG.info("Adding a razor to the order");
        orderService.addProduct(orderId, razor);
        return orderId;
    }

    private UUID createOrderIncompl() {
        Product notebook = new Product(UUID.randomUUID(), BigDecimal.valueOf(500), "Mac Pro");
        UUID orderId = orderService.createOrder(notebook);
        return orderId;
    }
}
