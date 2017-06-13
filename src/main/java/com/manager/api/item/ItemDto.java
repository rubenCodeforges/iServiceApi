package com.manager.api.item;

import com.manager.api.image.ImageDto;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Collection;

public class ItemDto {
    private Long id;
    @NotEmpty
    private String title;
    private String description;
    private Float price;
    private Currency currency;
    private Collection<ImageDto> images;

    public ItemDto() {
    }

    public ItemDto(String title) {
        this.title = title;
    }

    public ItemDto(Long id,
                   String title,
                   String description,
                   Float price,
                   Currency currency,
                   Collection<ImageDto> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
