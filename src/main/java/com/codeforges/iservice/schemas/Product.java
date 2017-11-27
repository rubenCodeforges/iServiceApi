package com.codeforges.iservice.schemas;

import java.time.LocalDateTime;
import java.util.Collection;

public class Product extends Thing {
    String productID;
    AggregateRating aggregateRating;
    Audience audience;
    Brand brand;
    Collection<Attribute> attributes;
    Collection<Category> categories;
    //    TODO: Those could be attribute
//    String color;
//    String award;
//    Number number;
//    Number heigth;
//    Number width;
//    Number weight;
    //String logo;
    Product isAccessoryOrSparePartFor;
    Product isConsumableFor;
    Product isRelatedTo;
    Collection<Product> isSimilarTo;
    ItemCondition itemCondition;
    Organization manufacturer;
    Product material;
    LocalDateTime productionDate;
    LocalDateTime purchaseDate;
    LocalDateTime releaseDate;
}
