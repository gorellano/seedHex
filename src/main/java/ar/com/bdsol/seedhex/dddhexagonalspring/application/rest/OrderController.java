package ar.com.bdsol.seedhex.dddhexagonalspring.application.rest;

import ar.com.bdsol.seedhex.dddhexagonalspring.application.request.AddProductRequest;
import ar.com.bdsol.seedhex.dddhexagonalspring.application.request.CreateOrderRequest;
import ar.com.bdsol.seedhex.dddhexagonalspring.application.response.CreateOrderResponse;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.Order;
import ar.com.bdsol.seedhex.dddhexagonalspring.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrderRequest createOrderRequest) {
        final UUID id = orderService.createOrder(createOrderRequest.getProduct());
        return new CreateOrderResponse(id);
    }

    @PostMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final UUID id, @RequestBody final AddProductRequest addProductRequest) {
        orderService.addProduct(id, addProductRequest.getProduct());
    }

    @DeleteMapping(value = "/{id}/products", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final UUID id, @RequestParam final UUID productId) {
        orderService.deleteProduct(id, productId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final UUID id) {
        orderService.completeOrder(id);
    }

}
