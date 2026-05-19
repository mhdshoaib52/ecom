package com.app.ecom.service;


import com.app.ecom.dto.OrderResponse;
import com.app.ecom.model.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final CartService cartService;
    public OrderResponse createOrder(String userId) {
        //validate for cart items
       List<CartItem> cartItem = cartService.getCartItems(userId) ;
       if (cartItem.isEmpty()){

       }
        //validate for user




        //calculate total price


        //create order

        //clear the cart
    }
}
