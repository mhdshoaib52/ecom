package com.app.ecom;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/api/users")
     public List<User> getAllUsers(){

         return userService.fetchAllUsers();
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
    public String createUsers( @Valid @RequestBody User user){
        System.out.println("POST hit: " + user);
        userService.addUser(user);
        return "user added succesfully";
    }

}
