package com.codeforges.iservice.api.order;

import com.codeforges.iservice.api.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "TB_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "TB_ORDER_ITEMS")
    private Collection<Item> items;

    private Date createdAt = new Date();

    private OrderState state = OrderState.NEW;

    private String description;

    public Order() {

    }

    public Order(String title) {
        this.title = title;
    }

    public Order(String title, Collection<Item> items) {
        this.title = title;
        this.items = items;
    }

    public Order(Long id,
                 String title,
                 OrderState state,
                 Date createdAt,
                 Collection<Item> items) {
        this.id = id;
        this.title = title;
        this.state = state;
        this.createdAt = createdAt;
        this.items = items;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
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

    public Collection<Item> getItems() {
        return items;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


