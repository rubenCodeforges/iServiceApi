package com.codeforges.ngShop.product._internal;

import com.codeforges.ngShop.product.Product;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinTable(name = "TB_ATTR_VALUE")
    private AttributeValue value;

    @ManyToMany(mappedBy = "attributes")
    Collection<Product> products;

    public Attribute() {
    }

    public Attribute(String name, AttributeValue value) {
        this.name = name;
        this.value = value;
    }

    public Attribute(String name, AttributeValue value, Collection<Product> products) {
        this.name = name;
        this.value = value;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeValue getValue() {
        return value;
    }

    public void setValue(AttributeValue value) {
        this.value = value;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
