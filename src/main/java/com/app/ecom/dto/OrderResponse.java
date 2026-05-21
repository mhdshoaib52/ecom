package com.app.ecom.dto;

import com.app.ecom.model.OrderItem;
import com.app.ecom.model.OrderStatus;
import com.app.ecom.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class OrderResponse {
    private String id;

    private BigDecimal totalAmount;

    private OrderStatus status ;

    private List<OrderItemDTO> items ;
    private LocalDateTime  createdAt;
}
