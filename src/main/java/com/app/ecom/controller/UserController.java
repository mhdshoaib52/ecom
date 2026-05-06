package com.app.ecom.controller;

import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.User;
import com.app.ecom.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;


    @GetMapping
//    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
     public ResponseEntity<List<UserResponse>> getAllUsers(){

         return new ResponseEntity<>(userService.fetchAllUsers(),
                 HttpStatus.OK);
     }
    @GetMapping("{id}")
    public ResponseEntity<Optional<UserResponse>> getUser(@PathVariable Long id) {
        Optional<UserResponse> user = userService.fetchUsers(id);
        if (user == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(user); // 200 with data
    }
    @PostMapping
    public ResponseEntity<String> createUsers( @Valid @RequestBody UserRequest userRequest){
        System.out.println("POST hit: " + userRequest);
        userService.addUser(userRequest);
        return ResponseEntity.ok("user added succesfully");
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUserRequest) {
        User user = userService.updateUsers(id, updatedUserRequest);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


}
