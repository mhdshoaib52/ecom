package com.app.ecom.repository;

import com.app.ecom.dto.ProductResponse;
import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByActiveTrue();
    @Query("{ 'active': true, 'stockQuantity': { $gt: 0 }, 'name': { $regex: ?0, $options: 'i' } }")
    List<Product> searchProduct(@Param("keyword") String keyword);
}
