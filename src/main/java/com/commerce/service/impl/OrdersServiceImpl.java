package com.commerce.service.impl;

import com.commerce.entity.Orders;
import com.commerce.error.Errors;
import com.commerce.mapper.OrderItemMapper;
import com.commerce.mapper.OrdersMapper;
import com.commerce.model.OrdersDto;
import com.commerce.repository.OrdersRepository;
import com.commerce.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<OrdersDto> findAll() {
        List<Orders> ordersList = ordersRepository.findAll();
        return ordersMapper.toDtoList(ordersList);
    }

    @Override
    public OrdersDto findById(int id) {
        Optional<Orders> ordersOptional = ordersRepository.findById(id);
        return ordersOptional.map(ordersMapper::toDto)
                .orElseThrow(() -> new Errors("Order not found"));
    }

    @Override
    public OrdersDto save(OrdersDto ordersDto) {
        Orders orders = ordersMapper.toEntity(ordersDto);
        Orders savedOrders = ordersRepository.save(orders);
        return ordersMapper.toDto(savedOrders);
    }

    @Override
    public OrdersDto update(int id, OrdersDto ordersDto) {
        Orders existingOrders = ordersRepository.findById(id)
                .orElseThrow(() -> new Errors("Order not found"));

        existingOrders.setOrder_date(ordersDto.getOrder_date());
        existingOrders.setTotal(ordersDto.getTotal());

        if (ordersDto.getItems() != null) {
            existingOrders.setItems(orderItemMapper.toEntityList(ordersDto.getItems()));
        }
        Orders updatedOrders = ordersRepository.save(existingOrders);
        return ordersMapper.toDto(updatedOrders);
    }

    @Override
    public void deleteById(int id) {
        Orders existingOrders = ordersRepository.findById(id)
                .orElseThrow(() -> new Errors("Order not found"));

        ordersRepository.deleteById(id);
    }
}
