package com.app.ecom.repository;

import com.app.ecom.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findBySerialId(Long serialId);
}