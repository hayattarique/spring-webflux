package org.boot.reactive.repositories;

import org.boot.reactive.entities.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
