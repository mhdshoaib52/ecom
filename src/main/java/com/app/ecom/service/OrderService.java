package com.app.ecom.service;


import com.app.ecom.dto.OrderResponse;
import com.app.ecom.model.*;
import com.app.ecom.repository.OrderRepository;
import com.app.ecom.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {


    private final CartService cartService;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    public Optional<OrderResponse> createOrder(String userId) {
        //validate for cart items
       List<CartItem> cartItem = cartService.getCartItem(userId) ;
       if (cartItem.isEmpty()){
           return Optional.empty();

       }
        //validate for user
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        User user = userOptional.get();


        //calculate total price
        BigDecimal totalPrice = cartItem.stream().map(CartItem::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);



        //create order
        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.CONFIRMED);
        order.setTotalAmount(totalPrice);
        List<OrderItem> orderItems = cartItem.stream().map(item -> new OrderItem(
                null,
                item.getProduct(),
                item.getQuantity(),
                item.getPrice(),
                order
        )).toList() ;
        order.setItems(orderItems);
        Order savedOrder = orderRepository.save(order);

        //clear the cart
        cartService.clearCart(userId);




    }
}
