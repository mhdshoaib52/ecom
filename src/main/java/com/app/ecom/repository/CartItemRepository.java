package com.app.ecom.repository;

import com.app.ecom.model.CartItem;
import com.app.ecom.model.Product;
import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends MongoRepository<CartItem, Long> {
    CartItem findByUserAndProduct(User user, Product product);
}
