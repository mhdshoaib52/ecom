package com.app.ecom;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/api/users")
     public ResponseEntity<List<User>> getAllUsers(){

         return new ResponseEntity<>(userService.fetchAllUsers(),
                 HttpStatus.OK);
     }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.fetchUsers(id);
        if (user == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(user); // 200 with data
    }
    @PostMapping("/api/users")
    public ResponseEntity<String> createUsers( @Valid @RequestBody User user){
        System.out.println("POST hit: " + user);
        userService.addUser(user);
        return ResponseEntity.ok("user added succesfully");
    }
    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUsers(id, updatedUser);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


}
