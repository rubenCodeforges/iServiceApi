package com.codeforges.iservice.schemas;


import java.time.LocalDateTime;

public class Product extends Thing {
    String productID;
    AggregateRating aggregateRating;
    Audience audience;
    Brand brand;
    Thing category;
    Attribute attribute;
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
    Product isSimilarTo;
    Object itemCondition;
    Organization manufacturer;
    Product material;
    // required ???
    ProductModel model;
    LocalDateTime productionDate;
    LocalDateTime purchaseDate;
    LocalDateTime releaseDate;
}
