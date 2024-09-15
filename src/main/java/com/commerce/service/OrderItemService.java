package com.commerce.service;

import com.commerce.model.OrderItemDto;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDto> findAll();
    OrderItemDto save(OrderItemDto orderItemDto);
    OrderItemDto findById(int id);
    OrderItemDto update(int id, OrderItemDto orderItemDto);
    void deleteById(int id);
}
