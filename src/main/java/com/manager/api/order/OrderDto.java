package com.manager.api.order;

import com.manager.api.item.ItemDto;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Collection;
import java.util.Date;

public class OrderDto {
    private Long id;
    @NotEmpty
    private String title;
    private OrderState state;
    private Date createdAt;
    private Collection<ItemDto> items;
    private String description;

    public OrderDto() {
    }

    public OrderDto(Long id,
                    String title,
                    OrderState state,
                    Date createdAt,
                    Collection<ItemDto> items,
                    String description) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.description = description;
        this.createdAt = createdAt;
        this.items = items;
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

    public Collection<ItemDto> getItems() {
        return items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
