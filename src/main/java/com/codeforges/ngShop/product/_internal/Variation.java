package com.codeforges.ngShop.product._internal;

import com.codeforges.ngShop.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "TB_VARIATION")
public class Variation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinTable(name = "TB_PRODUCT")
    private Product product;

    public Variation(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
