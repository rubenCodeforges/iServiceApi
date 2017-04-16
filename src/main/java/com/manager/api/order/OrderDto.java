package com.manager.api.order;

import com.manager.api.item.Item;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

public class OrderDto {
    private Long id;

    @NotNull
    private String title;
    private Collection<Item> items;
    private Date createdAt = new Date();
    private OrderState state = OrderState.NEW;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }
}
