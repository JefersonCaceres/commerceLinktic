package com.commerce.mapper;

import com.commerce.entity.Orders;
import com.commerce.model.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdersMapper {
    @Autowired
    private OrderItemMapper orderItemMapper;

    // Convertir de entidad a DTO
    public OrdersDto toDto(Orders orders) {
        OrdersDto dto = new OrdersDto();
        dto.setId(orders.getId());
        dto.setOrder_date(orders.getOrder_date());
        dto.setTotal(orders.getTotal());

        // Mapea la lista de OrderItems utilizando el OrderItemMapper
        if (orders.getItems() != null) {
            dto.setItems(orderItemMapper.toDtoList(orders.getItems()));
        }

        return dto;
    }

    // Convertir de DTO a entidad
    public Orders toEntity(OrdersDto ordersDto) {
        Orders orders = new Orders();
        orders.setId(ordersDto.getId());
        orders.setOrder_date(ordersDto.getOrder_date());
        orders.setTotal(ordersDto.getTotal());

        // Mapea la lista de OrderItems utilizando el OrderItemMapper
        if (ordersDto.getItems() != null) {
            orders.setItems(orderItemMapper.toEntityList(ordersDto.getItems()));
        }

        return orders;
    }

    // Convertir una lista de entidades a una lista de DTOs
    public List<OrdersDto> toDtoList(List<Orders> ordersList) {
        return ordersList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Convertir una lista de DTOs a una lista de entidades
    public List<Orders> toEntityList(List<OrdersDto> ordersDtoList) {
        return ordersDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
