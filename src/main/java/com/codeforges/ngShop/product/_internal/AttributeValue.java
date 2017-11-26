package com.codeforges.ngShop.product._internal;

import javax.persistence.*;

@Entity
@Table(name = "TB_ATTR_VALUE")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "value")
    Attribute attribute;

    String value;

    public AttributeValue(Attribute attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

    public AttributeValue() {
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Long getId() {
        return id;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
