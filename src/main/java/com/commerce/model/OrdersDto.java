package com.commerce.model;

import java.util.List;

public class OrdersDto {
    private int id;
    private String  order_date;
    private float total;
    private List<OrderItemDto> items;


    public OrdersDto() {
    }

    public OrdersDto(int id, String order_date, float total, List<OrderItemDto> items) {
        this.id = id;
        this.order_date = order_date;
        this.total = total;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
