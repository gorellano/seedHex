package ar.com.bdsol.seedhex.dddhexagonalspring.infrastructure.repository.mongo;

import ar.com.bdsol.seedhex.dddhexagonalspring.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoOrderRepository extends MongoRepository<Order, UUID> {
}
