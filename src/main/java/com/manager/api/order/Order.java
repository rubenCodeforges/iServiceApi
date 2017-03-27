package com.manager.api.order;

import com.manager.api.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @OneToMany(mappedBy = "order")
    private Collection<Item> items;

    private Date createdAt = new Date();

    public Order() {
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

    public Collection<Item> getItems() {
        return items;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}


