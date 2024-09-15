package com.commerce.service;

import com.commerce.model.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> findAll();
    OrdersDto findById(int id);
    OrdersDto save(OrdersDto ordersDto);
    OrdersDto update(int id, OrdersDto ordersDto);
    void deleteById(int id);

}
