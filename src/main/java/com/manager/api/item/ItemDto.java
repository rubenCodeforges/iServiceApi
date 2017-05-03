package com.manager.api.item;

import com.manager.api.image.ImageDto;
import com.manager.api.order.Order;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public class ItemDto {
    private Long id;
    @NotNull
    private String title;
    private Collection<Order> orders;
    private String description;
    private Float price;
    private Currency currency;
    private Collection<Ima> images;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Collection<ImageDto> getImages() {
        return images;
    }

    public void setImages(Collection<ImageDto> images) {
        this.images = images;
    }
}
