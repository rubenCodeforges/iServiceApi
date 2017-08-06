package com.manager.api.item;


import com.manager.api.image.Image;
import com.manager.api.order.Order;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@CrossOrigin
@Entity
@Table(name = "TB_ITEM")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @ManyToMany(mappedBy = "items", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Order> orders;

    private String description;

    private Float price;

    private Currency currency = Currency.UAH;

    @ManyToMany
    @JoinTable(name = "TB_ITEM_IMAGES")
    private Collection<Image> images;

    public Item() {
    }

    public Item(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Item(String title,
                String description,
                Float price,
                Currency currency) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    public Item(String title,
                String description,
                Float price,
                Currency currency,
                Collection<Image> images) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.images = images;
    }
    public Item(Long id,
                String title,
                String description,
                Float price,
                Currency currency,
                Collection<Image> images) {
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

    public void setOrder(Collection<Order> orders) {
        this.orders = orders;
    }

    public Collection<Order> getOrders() {
        return this.orders;
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

    public Collection<Image> getImages() {
        return this.images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }
}
