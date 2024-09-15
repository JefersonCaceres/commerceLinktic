package com.commerce.mapper;

import com.commerce.entity.OrderItem;
import com.commerce.entity.Orders;
import com.commerce.entity.Product;
import com.commerce.model.OrderItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapper {
    public OrderItemDto toDto(OrderItem orderItem) {
        OrderItemDto dto = new OrderItemDto();
        dto.setId(orderItem.getId());
        dto.setOrderId(orderItem.getOrder().getId());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setAmount(orderItem.getAmount());
        dto.setTotal(orderItem.getTotal());
        return dto;
    }
    public OrderItem toEntity(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        Orders order = new Orders();

        order.setId(orderItemDto.getOrderId());

        Product product = new Product();
        product.setId(orderItemDto.getProductId());

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setAmount(orderItemDto.getAmount());
        orderItem.setTotal(orderItemDto.getTotal());

        return orderItem;
    }

    public List<OrderItemDto> toDtoList(List<OrderItem> orderItemList) {
        return orderItemList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<OrderItem> toEntityList(List<OrderItemDto> orderItemDtoList) {
        return orderItemDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
