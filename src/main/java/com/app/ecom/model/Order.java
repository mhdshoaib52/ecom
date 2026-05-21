package com.app.ecom.model;


import com.app.ecom.repository.OrderRepository;
import jakarta.websocket.OnError;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "order")

public class Order {

    private String id;
    private User user;
    private BigDecimal totalAmount;

    private OrderStatus status = OrderStatus.PENDING;

    private List<OrderItem> items = new ArrayList<>();
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


}

