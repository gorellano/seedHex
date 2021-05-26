package ar.com.bdsol.seedhex.dddhexagonalspring.domain.repository;

import ar.com.bdsol.seedhex.dddhexagonalspring.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> findById(UUID id);
    void save(Order order);
}
