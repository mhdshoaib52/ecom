package com.app.ecom.controller;


import com.app.ecom.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")

public class CartController {
    private final CartService cartService;
    @PutMapping
    public ResponseEntity<void> addToCart(
            @RequestHeader("X-User_ID") String userId,
             @RequestBody CartItemRequest request){

        cartService.addToCart(userId,request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
