package com.manager.api.item;

import com.manager.api.order.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public class Item {
    @Id
    @NotNull
    private String id;
    @NotNull
    private String title;
    private String description;
    @DBRef
    private Order order;

    public Item(String title, String description, Order order) {
        this.title = title;
        this.description = description;
        this.order = order;
    }

    public String getId() {
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
