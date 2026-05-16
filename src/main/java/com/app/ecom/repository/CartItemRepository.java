package com.app.ecom.repository;

import com.app.ecom.model.CartItem;
import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, String> {
    @Query("{ 'user._id': ?0, 'product._id': ?1 }")
    CartItem findByUserIdAndProductId(String userId, String productId);



    void deleteByUserAndProduct(User user, Product product);
}
