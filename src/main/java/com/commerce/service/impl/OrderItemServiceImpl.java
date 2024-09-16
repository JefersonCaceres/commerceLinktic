package com.commerce.service.impl;

import com.commerce.entity.OrderItem;
import com.commerce.error.Errors;
import com.commerce.mapper.OrderItemMapper;
import com.commerce.model.OrderItemDto;
import com.commerce.repository.OrderItemRepository;
import com.commerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public List<OrderItemDto> findAll() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItemMapper.toDtoList(orderItems);
    }
    @Override
    public OrderItemDto save(OrderItemDto orderItemDto) {
        if (orderItemRepository.existsById(orderItemDto.getId())) {
            throw new Errors("OrderItem already exists with id: " + orderItemDto.getId());
        }
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDto);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(savedOrderItem);
    }

    // Encontrar un OrderItem por ID
    @Override
    public OrderItemDto findById(int id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        return orderItemOptional.map(orderItemMapper::toDto)
                .orElseThrow(() -> new Errors("OrderItem not found"));
    }

    // Actualizar un OrderItem existente
    @Override
    public OrderItemDto update(int id, OrderItemDto orderItemDto) {
        OrderItem existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new Errors("OrderItem not found"));

        existingOrderItem.setAmount(orderItemDto.getAmount());
        existingOrderItem.setTotal(orderItemDto.getTotal());
        existingOrderItem.setOrder(orderItemMapper.toEntity(orderItemDto).getOrder());
        existingOrderItem.setProduct(orderItemMapper.toEntity(orderItemDto).getProduct());

        OrderItem updatedOrderItem = orderItemRepository.save(existingOrderItem);

        return orderItemMapper.toDto(updatedOrderItem);
    }

    // Eliminar un OrderItem por ID
    @Override
    public void deleteById(int id) {
        orderItemRepository.findById(id)
                .orElseThrow(() -> new Errors("OrderItem not found"));
        orderItemRepository.deleteById(id);
    }
}
