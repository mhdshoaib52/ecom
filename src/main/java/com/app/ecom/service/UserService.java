package com.app.ecom.service;

import com.app.ecom.dto.UserResponse;
import com.app.ecom.repository.UserRepository;
import com.app.ecom.model.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private Long nextId = 101L;

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        user.setSerialId(nextId++);

        userRepository.save(user);
    }

    // UserService.java
    public  User fetchUsers(Long serialId) {
        return userRepository.findBySerialId(serialId);
    }
    public User updateUsers(Long serialId, User updatedUser) {
        User existing = userRepository.findBySerialId(serialId);
        if (existing == null) return null;
        existing.setFirstName(updatedUser.getFirstName());
        existing.setLastName(updatedUser.getLastName());
        return userRepository.save(existing);
    }
    private UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(String.valueOf(user.getFirstName()));
        response.setLastName(String.valueOf(user.getLastName()));
        response.setEmail(String.valueOf(user.getEmail()));
        response.setId(String.valueOf(user.getId()));
        response.setPhone(String.valueOf(user.getPhone()));
        response.setRole(String.valueOf(user.getRole()));

        if (user.getAddress() != null) {
            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setStreet(user.getAddress().getStreet());
            addressResponse.setCity(user.getAddress().getCity());
            addressResponse.setState(user.getAddress().getState());
            addressResponse.setCountry(user.getAddress().getCountry());
            addressResponse.setZipCode(user.getAddress().getZipCode());

            response.setAddress(addressResponse);
        }

    }

}