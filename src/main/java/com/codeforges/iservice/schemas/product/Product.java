package com.codeforges.iservice.schemas.product;

import com.codeforges.iservice.schemas.common.Thing;
import com.codeforges.iservice.schemas.organization.Brand;
import com.codeforges.iservice.schemas.organization.Organization;
import com.codeforges.iservice.schemas.rating.AggregateRating;

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
