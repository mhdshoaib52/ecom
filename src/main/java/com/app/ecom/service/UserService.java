package com.app.ecom.service;

import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.UserRole;
import com.app.ecom.repository.UserRepository;
import com.app.ecom.model.User;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private Long nextId = 101L;

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponse).collect(Collectors.toList());
    }

    private final AtomicLong nextId = new AtomicLong(101L);

    public void addUser(UserRequest userRequest) {
        User user = new User();
        user.setSerialId(nextId.getAndIncrement());
        updateUserFromRequest(user, userRequest);
        userRepository.save(user);
    }



    // UserService.java
    public Optional<UserResponse> fetchUsers(String id) {
        return userRepository.findById(id).map(this::mapToUserResponse);
    }
    private void updateUserFromRequest(User user, UserRequest userRequest) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());

        if (userRequest.getAddressDTO() != null){
            Address address = new Address();
            address.setStreet(userRequest.getAddressDTO().getStreet());
            address.setState(userRequest.getAddressDTO().getState());
            address.setCountry(userRequest.getAddressDTO().getCountry());
            address.setZipCode(userRequest.getAddressDTO().getZipCode());
            address.setCity(userRequest.getAddressDTO().getCity());
            user.setAddress(address);
        }
    }
    public User updateUsers(String id, UserRequest updatedUserRequest) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existing.setFirstName(updatedUserRequest.getFirstName());
        existing.setLastName(updatedUserRequest.getLastName());
        return userRepository.save(existing);
    }
    private UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setSerialId(user.getSerialId());
        response.setFirstName(String.valueOf(user.getFirstName()));
        response.setLastName(String.valueOf(user.getLastName()));
        response.setEmail(String.valueOf(user.getEmail()));
        response.setId(String.valueOf(user.getId()));
        response.setPhone(String.valueOf(user.getPhone()));
        response.setRole(UserRole.valueOf(String.valueOf(user.getRole())));

        if (user.getAddress() != null) {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());
            addressDTO.setCountry(user.getAddress().getCountry());
            addressDTO.setZipCode(user.getAddress().getZipCode());

            response.setAddressDTO(addressDTO);
        }
        return response;
    }

}