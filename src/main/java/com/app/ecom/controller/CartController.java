package com.app.ecom.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @PutMapping
    public ResponseEntity<void> addToCart(
            @RequestHeader("X-User_ID") String userId;
            CartItemRequest request
    )
}
