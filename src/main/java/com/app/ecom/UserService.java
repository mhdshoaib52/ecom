package com.app.ecom;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private Long nextId = 101L;

    public List<User> fetchAllUsers() {
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

}