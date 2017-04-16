package com.manager.api.item;


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

    @ManyToMany(mappedBy = "items")
    private Collection<Order> orders;

    private String description;

    public Item() {
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
}
