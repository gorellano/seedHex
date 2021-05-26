package ar.com.bdsol.seedhex.dddhexagonalspring.infrastructure.configuration;

import ar.com.bdsol.seedhex.dddhexagonalspring.infrastructure.repository.mongo.SpringDataMongoOrderRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoOrderRepository.class)
public class MongoDBConfiguration {
}
