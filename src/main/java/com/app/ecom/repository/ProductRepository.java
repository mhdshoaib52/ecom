package com.app.ecom.repository;

import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByActiveTrue();
}
