package com.codeforges.ngShop.product;

import com.codeforges.ngShop.product._internal.Attribute;
import com.codeforges.ngShop.product._internal.Option;
import com.codeforges.ngShop.product._internal.Variation;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String slug;
    private String description;
    private String metaKeywords;
    private String metaDescription;
    @ManyToMany
    @JoinTable(name = "TB_ATTRIBUTE")
    private Collection<Attribute> attributes;

    @OneToMany(mappedBy = "product")
    private Collection<Variation> variations;
//    private Collection<Option> options;
//    private String images;
//    private String createdAt;
//    private String updatedAt;


    public Product() {
    }

    public Product(String name, String slug, String description) {
        this.name = name;
        this.slug = slug;
        this.description = description;
    }

    public Product(String name,
                   String slug,
                   String description,
                   String metaKeywords,
                   String metaDescription,
                   Collection<Attribute> attributes,
                   Collection<Variation> variations,
                   Collection<Option> options) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.metaKeywords = metaKeywords;
        this.metaDescription = metaDescription;
        this.attributes = attributes;
        this.variations = variations;
//        this.options = options;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public Collection<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Collection<Variation> getVariations() {
        return variations;
    }

    public void setVariations(Collection<Variation> variations) {
        this.variations = variations;
    }

    //    public Collection<Option> getOptions() {
//        return options;
//    }
//
//    public void setOptions(Collection<Option> options) {
//        this.options = options;
//    }
}