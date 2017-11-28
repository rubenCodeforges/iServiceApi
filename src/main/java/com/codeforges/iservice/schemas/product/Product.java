package com.codeforges.iservice.schemas.product;

import java.time.LocalDateTime;
import java.util.Collection;

public class Product extends Thing {
    String productID;
    ProductStatus productStatus;
    AggregateRating aggregateRating;
    Audience audience;
    Brand brand;
    Collection<Attribute> attributes;
    Collection<Category> categories;
    Collection<Product> isAccessoryOrSparePartFor;
    Collection<Product> isConsumableFor;
    Collection<ProductRelation> isRelatedTo;
    Collection<Product> isSimilarTo;
    Organization manufacturer;
    Collection<Product> material;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
