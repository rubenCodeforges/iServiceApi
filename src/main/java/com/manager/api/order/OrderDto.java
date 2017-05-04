package com.manager.api.order;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class OrderDto {
    private Long id;
    @NotEmpty
    private String title;
    private OrderState state;
    private Date createdAt;

    public OrderDto(Long id, String title, OrderState state, Date createdAt) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
