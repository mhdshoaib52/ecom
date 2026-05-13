package com.app.ecom.repository;

import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Object> findByActiveTrue();
}
