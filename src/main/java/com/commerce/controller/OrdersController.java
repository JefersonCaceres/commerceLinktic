package com.commerce.controller;

import com.commerce.model.OrdersDto;
import com.commerce.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;


    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


    @GetMapping
    public ResponseEntity<List<OrdersDto>> getAllOrders() {
        List<OrdersDto> orders = ordersService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<OrdersDto> getOrderById(@PathVariable int id) {
        OrdersDto order = ordersService.findById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<OrdersDto> createOrder(@RequestBody OrdersDto ordersDto) {
        OrdersDto createdOrder = ordersService.save(ordersDto);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrdersDto> updateOrder(@PathVariable int id, @RequestBody OrdersDto ordersDto) {
        OrdersDto updatedOrder = ordersService.update(id, ordersDto);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable int id) {
        ordersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
