package com.order.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    private String username;
    private Item item;
    private Integer orderTotal;

    @JsonCreator
    public Order(@JsonProperty("username") String username,
                 @JsonProperty("item") Item item,
                 @JsonProperty("orderTotal") Integer orderTotal) {
        this.username = username;
        this.item = item;
        this.orderTotal = orderTotal;
    }

    public String getUsername() {
        return username;
    }

    public Item getItem() {
        return item;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    @Override
    public String toString() {
        return "Order{" +
                "username='" + username + '\'' +
                ", item=" + item +
                ", orderTotal=" + orderTotal +
                '}';
    }
}
