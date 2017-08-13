package com.codeforges.iservice.api.order;

import com.codeforges.iservice.api.item.ItemDto;

import java.util.Collection;

public class OrderCreateDto {
    private String title;
    private Collection<ItemDto> items;
    private OrderState state;

    public OrderCreateDto() {

    }

    public OrderCreateDto(String title,
                          Collection<ItemDto> items,
                          OrderState state) {
        this.title = title;
        this.items = items;
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<ItemDto> getItems() {
        return items;
    }

    public void setItems(Collection<ItemDto> items) {
        this.items = items;
    }
}
