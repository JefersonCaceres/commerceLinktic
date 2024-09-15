package com.commerce.controller;

import com.commerce.model.OrderItemDto;
import com.commerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDto> createOrderItem(@RequestBody OrderItemDto orderItemDto) {
        OrderItemDto savedOrderItem = orderItemService.save(orderItemDto);
        return ResponseEntity.ok(savedOrderItem);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        List<OrderItemDto> orderItems = orderItemService.findAll();
        return ResponseEntity.ok(orderItems);
    }
}
