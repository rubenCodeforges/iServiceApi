package com.codeforges.iservice.schemas.product;

import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.organization.Brand;
import com.codeforges.iservice.schemas.organization.Organization;
import com.codeforges.iservice.schemas.rating.AggregateRating;

import java.time.LocalDateTime;
import java.util.Collection;

public class Product extends Thing {
    private String productID;
    private ProductStatus productStatus;
    private AggregateRating aggregateRating;
    private Audience audience;
    private Brand brand;
    private Collection<Attribute> attributes;
    private Collection<Category> categories;
    private Collection<Product> isAccessoryOrSparePartFor;
    private Collection<Product> isConsumableFor;
    private Collection<ProductRelation> isRelatedTo;
    private Collection<Product> isSimilarTo;
    private Organization manufacturer;
    private Collection<Product> material;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
